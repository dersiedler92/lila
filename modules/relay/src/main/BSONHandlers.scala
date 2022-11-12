package lila.relay

import reactivemongo.api.bson._

import lila.db.dsl.{ *, given }

object BSONHandlers {

  given BSONHandler[RelayRound.Id]               = stringAnyValHandler(_.value, RelayRound.Id)
  given tourIdHandler: BSONHandler[RelayTour.Id] = stringAnyValHandler(_.value, RelayTour.Id)
  given BSONHandler[RelayPlayers]                = stringAnyValHandler(_.text, RelayPlayers)

  import RelayRound.Sync
  import Sync.{ Upstream, UpstreamIds, UpstreamUrl }
  given upstreamUrlHandler: BSONDocumentHandler[UpstreamUrl] = Macros.handler
  given upstreamIdsHandler: BSONDocumentHandler[UpstreamIds] = Macros.handler

  given BSONHandler[Upstream] = tryHandler(
    {
      case d: BSONDocument if d.contains("url") => upstreamUrlHandler readTry d
      case d: BSONDocument if d.contains("ids") => upstreamIdsHandler readTry d
    },
    {
      case url: UpstreamUrl => upstreamUrlHandler.writeTry(url).get
      case ids: UpstreamIds => upstreamIdsHandler.writeTry(ids).get
    }
  )

  import SyncLog.Event
  given BSONDocumentHandler[Event] = Macros.handler

  given BSONHandler[SyncLog] = isoHandler[SyncLog, Vector[Event]](_.events, SyncLog)

  given BSONDocumentHandler[Sync] = Macros.handler

  given BSONDocumentHandler[RelayRound] = Macros.handler

  given BSONDocumentHandler[RelayTour] = Macros.handler

  def readRoundWithTour(doc: Bdoc): Option[RelayRound.WithTour] = for {
    round <- doc.asOpt[RelayRound]
    tour  <- doc.getAsOpt[RelayTour]("tour")
  } yield RelayRound.WithTour(round, tour)
}
