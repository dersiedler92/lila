package org.lichess.compression.game;

// Precomputed overlapping fixed shift magics:
// https://chessprogramming.wikispaces.com/Magic+Bitboards#FixedShiftFancy
class Magic {

    // Mask relevant occupancies.
    public long mask;

    // Magic factor.
    public long factor;

    // Offset in overlapping table.
    public int offset;

    public Magic(long mask, long factor, int offset) {
        this.mask = mask;
        this.factor = factor;
        this.offset = offset;
    }

    public static Magic ROOK[] = {
        new Magic(0x000101010101017eL, 0x00280077ffebfffeL, 26304),
        new Magic(0x000202020202027cL, 0x2004010201097fffL, 35520),
        new Magic(0x000404040404047aL, 0x0010020010053fffL, 38592),
        new Magic(0x0008080808080876L, 0x0040040008004002L,  8026),
        new Magic(0x001010101010106eL, 0x7fd00441ffffd003L, 22196),
        new Magic(0x002020202020205eL, 0x4020008887dffffeL, 80870),
        new Magic(0x004040404040403eL, 0x004000888847ffffL, 76747),
        new Magic(0x008080808080807eL, 0x006800fbff75fffdL, 30400),
        new Magic(0x0001010101017e00L, 0x000028010113ffffL, 11115),
        new Magic(0x0002020202027c00L, 0x0020040201fcffffL, 18205),
        new Magic(0x0004040404047a00L, 0x007fe80042ffffe8L, 53577),
        new Magic(0x0008080808087600L, 0x00001800217fffe8L, 62724),
        new Magic(0x0010101010106e00L, 0x00001800073fffe8L, 34282),
        new Magic(0x0020202020205e00L, 0x00001800e05fffe8L, 29196),
        new Magic(0x0040404040403e00L, 0x00001800602fffe8L, 23806),
        new Magic(0x0080808080807e00L, 0x000030002fffffa0L, 49481),
        new Magic(0x00010101017e0100L, 0x00300018010bffffL,  2410),
        new Magic(0x00020202027c0200L, 0x0003000c0085fffbL, 36498),
        new Magic(0x00040404047a0400L, 0x0004000802010008L, 24478),
        new Magic(0x0008080808760800L, 0x0004002020020004L, 10074),
        new Magic(0x00101010106e1000L, 0x0001002002002001L, 79315),
        new Magic(0x00202020205e2000L, 0x0001001000801040L, 51779),
        new Magic(0x00404040403e4000L, 0x0000004040008001L, 13586),
        new Magic(0x00808080807e8000L, 0x0000006800cdfff4L, 19323),
        new Magic(0x000101017e010100L, 0x0040200010080010L, 70612),
        new Magic(0x000202027c020200L, 0x0000080010040010L, 83652),
        new Magic(0x000404047a040400L, 0x0004010008020008L, 63110),
        new Magic(0x0008080876080800L, 0x0000040020200200L, 34496),
        new Magic(0x001010106e101000L, 0x0002008010100100L, 84966),
        new Magic(0x002020205e202000L, 0x0000008020010020L, 54341),
        new Magic(0x004040403e404000L, 0x0000008020200040L, 60421),
        new Magic(0x008080807e808000L, 0x0000820020004020L, 86402),
        new Magic(0x0001017e01010100L, 0x00fffd1800300030L, 50245),
        new Magic(0x0002027c02020200L, 0x007fff7fbfd40020L, 76622),
        new Magic(0x0004047a04040400L, 0x003fffbd00180018L, 84676),
        new Magic(0x0008087608080800L, 0x001fffde80180018L, 78757),
        new Magic(0x0010106e10101000L, 0x000fffe0bfe80018L, 37346),
        new Magic(0x0020205e20202000L, 0x0001000080202001L,   370),
        new Magic(0x0040403e40404000L, 0x0003fffbff980180L, 42182),
        new Magic(0x0080807e80808000L, 0x0001fffdff9000e0L, 45385),
        new Magic(0x00017e0101010100L, 0x00fffefeebffd800L, 61659),
        new Magic(0x00027c0202020200L, 0x007ffff7ffc01400L, 12790),
        new Magic(0x00047a0404040400L, 0x003fffbfe4ffe800L, 16762),
        new Magic(0x0008760808080800L, 0x001ffff01fc03000L,     0),
        new Magic(0x00106e1010101000L, 0x000fffe7f8bfe800L, 38380),
        new Magic(0x00205e2020202000L, 0x0007ffdfdf3ff808L, 11098),
        new Magic(0x00403e4040404000L, 0x0003fff85fffa804L, 21803),
        new Magic(0x00807e8080808000L, 0x0001fffd75ffa802L, 39189),
        new Magic(0x007e010101010100L, 0x00ffffd7ffebffd8L, 58628),
        new Magic(0x007c020202020200L, 0x007fff75ff7fbfd8L, 44116),
        new Magic(0x007a040404040400L, 0x003fff863fbf7fd8L, 78357),
        new Magic(0x0076080808080800L, 0x001fffbfdfd7ffd8L, 44481),
        new Magic(0x006e101010101000L, 0x000ffff810280028L, 64134),
        new Magic(0x005e202020202000L, 0x0007ffd7f7feffd8L, 41759),
        new Magic(0x003e404040404000L, 0x0003fffc0c480048L,  1394),
        new Magic(0x007e808080808000L, 0x0001ffffafd7ffd8L, 40910),
        new Magic(0x7e01010101010100L, 0x00ffffe4ffdfa3baL, 66516),
        new Magic(0x7c02020202020200L, 0x007fffef7ff3d3daL,  3897),
        new Magic(0x7a04040404040400L, 0x003fffbfdfeff7faL,  3930),
        new Magic(0x7608080808080800L, 0x001fffeff7fbfc22L, 72934),
        new Magic(0x6e10101010101000L, 0x0000020408001001L, 72662),
        new Magic(0x5e20202020202000L, 0x0007fffeffff77fdL, 56325),
        new Magic(0x3e40404040404000L, 0x0003ffffbf7dfeecL, 66501),
        new Magic(0x7e80808080808000L, 0x0001ffff9dffa333L, 14826),
    };

    public static Magic BISHOP[] = {
        new Magic(0x0040201008040200L, 0x007fbfbfbfbfbfffL,  5378),
        new Magic(0x0000402010080400L, 0x0000a060401007fcL,  4093),
        new Magic(0x0000004020100a00L, 0x0001004008020000L,  4314),
        new Magic(0x0000000040221400L, 0x0000806004000000L,  6587),
        new Magic(0x0000000002442800L, 0x0000100400000000L,  6491),
        new Magic(0x0000000204085000L, 0x000021c100b20000L,  6330),
        new Magic(0x0000020408102000L, 0x0000040041008000L,  5609),
        new Magic(0x0002040810204000L, 0x00000fb0203fff80L, 22236),
        new Magic(0x0020100804020000L, 0x0000040100401004L,  6106),
        new Magic(0x0040201008040000L, 0x0000020080200802L,  5625),
        new Magic(0x00004020100a0000L, 0x0000004010202000L, 16785),
        new Magic(0x0000004022140000L, 0x0000008060040000L, 16817),
        new Magic(0x0000000244280000L, 0x0000004402000000L,  6842),
        new Magic(0x0000020408500000L, 0x0000000801008000L,  7003),
        new Magic(0x0002040810200000L, 0x000007efe0bfff80L,  4197),
        new Magic(0x0004081020400000L, 0x0000000820820020L,  7356),
        new Magic(0x0010080402000200L, 0x0000400080808080L,  4602),
        new Magic(0x0020100804000400L, 0x00021f0100400808L,  4538),
        new Magic(0x004020100a000a00L, 0x00018000c06f3fffL, 29531),
        new Magic(0x0000402214001400L, 0x0000258200801000L, 45393),
        new Magic(0x0000024428002800L, 0x0000240080840000L, 12420),
        new Magic(0x0002040850005000L, 0x000018000c03fff8L, 15763),
        new Magic(0x0004081020002000L, 0x00000a5840208020L,  5050),
        new Magic(0x0008102040004000L, 0x0000020008208020L,  4346),
        new Magic(0x0008040200020400L, 0x0000804000810100L,  6074),
        new Magic(0x0010080400040800L, 0x0001011900802008L,  7866),
        new Magic(0x0020100a000a1000L, 0x0000804000810100L, 32139),
        new Magic(0x0040221400142200L, 0x000100403c0403ffL, 57673),
        new Magic(0x0002442800284400L, 0x00078402a8802000L, 55365),
        new Magic(0x0004085000500800L, 0x0000101000804400L, 15818),
        new Magic(0x0008102000201000L, 0x0000080800104100L,  5562),
        new Magic(0x0010204000402000L, 0x00004004c0082008L,  6390),
        new Magic(0x0004020002040800L, 0x0001010120008020L,  7930),
        new Magic(0x0008040004081000L, 0x000080809a004010L, 13329),
        new Magic(0x00100a000a102000L, 0x0007fefe08810010L,  7170),
        new Magic(0x0022140014224000L, 0x0003ff0f833fc080L, 27267),
        new Magic(0x0044280028440200L, 0x007fe08019003042L, 53787),
        new Magic(0x0008500050080400L, 0x003fffefea003000L,  5097),
        new Magic(0x0010200020100800L, 0x0000101010002080L,  6643),
        new Magic(0x0020400040201000L, 0x0000802005080804L,  6138),
        new Magic(0x0002000204081000L, 0x0000808080a80040L,  7418),
        new Magic(0x0004000408102000L, 0x0000104100200040L,  7898),
        new Magic(0x000a000a10204000L, 0x0003ffdf7f833fc0L, 42012),
        new Magic(0x0014001422400000L, 0x0000008840450020L, 57350),
        new Magic(0x0028002844020000L, 0x00007ffc80180030L, 22813),
        new Magic(0x0050005008040200L, 0x007fffdd80140028L, 56693),
        new Magic(0x0020002010080400L, 0x00020080200a0004L,  5818),
        new Magic(0x0040004020100800L, 0x0000101010100020L,  7098),
        new Magic(0x0000020408102000L, 0x0007ffdfc1805000L,  4451),
        new Magic(0x0000040810204000L, 0x0003ffefe0c02200L,  4709),
        new Magic(0x00000a1020400000L, 0x0000000820806000L,  4794),
        new Magic(0x0000142240000000L, 0x0000000008403000L, 13364),
        new Magic(0x0000284402000000L, 0x0000000100202000L,  4570),
        new Magic(0x0000500804020000L, 0x0000004040802000L,  4282),
        new Magic(0x0000201008040200L, 0x0004010040100400L, 14964),
        new Magic(0x0000402010080400L, 0x00006020601803f4L,  4026),
        new Magic(0x0002040810204000L, 0x0003ffdfdfc28048L,  4826),
        new Magic(0x0004081020400000L, 0x0000000820820020L,  7354),
        new Magic(0x000a102040000000L, 0x0000000008208060L,  4848),
        new Magic(0x0014224000000000L, 0x0000000000808020L, 15946),
        new Magic(0x0028440200000000L, 0x0000000001002020L, 14932),
        new Magic(0x0050080402000000L, 0x0000000401002008L, 16588),
        new Magic(0x0020100804020000L, 0x0000004040404040L,  6905),
        new Magic(0x0040201008040200L, 0x007fff9fdf7ff813L, 16076),
    };
}
