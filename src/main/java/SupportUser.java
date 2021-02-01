import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupportUser {
    //0929 新知

    private static List<String> newUserList = Arrays.asList("5e151a210000000001009a34", "5a05c4fa4eacab6ae23b7e61", "5cfb8d24000000001602e972", "5b5af7b0e8ac2b2428e4fe8f", "5ba5f73def996a0001f06363", "5da719be00000000010017fd", "5d5644ef0000000001008852", "5f45cec90000000001009604", "5bc825aa2ace7700013535ad", "5f4fb8af000000000100b161", "5b2afdf311be104ac3c22931", "5f2103e1000000000100a7b7", "5cd14bf00000000012026828", "5981b4e950c4b4369e4a2785", "5f2940b6000000000101e724", "5f5c2aa90000000001004133", "5e7eab3c0000000001007a30", "58fd6d5250c4b42332a4027a", "5ad2b92f11be106226d7c241", "5d746c7b0000000001002e27", "5efa6253000000000101c328", "5e8033dd000000000100b995", "5b487eb911be100837411550", "5db8f73e0000000001006454", "5ee464330000000001003810", "5af2eb354eacab39393b6554", "5c0e752b51783a23c257d705", "5f2e64a300000000010003c5", "5f323e880000000001008587", "5b463a7711be10622c103cc3", "5c09505a00000000050149e7", "5a94e67de8ac2b2bed6a6729", "5aa5c2904eacab2a4039070e", "5e920b3d0000000001000594", "5c98773100000000100178fb", "5b28f85b4eacab71d4e84ddb", "57a1a19182ec3926357da1f8", "5c7aa42b000000001603baa4", "5f22c6f8000000000101d683", "5dbd1ca3000000000100187e", "5e672e710000000001005d60", "5b422a0311be106ec0b739c0", "5771e1185e87e74a3f70927a", "5b66766e06825b0001d0854d", "5a4231044eacab7d8ff1e91f", "5da81cda00000000010022ab", "5c3f40080000000007009a64", "5cb9ee710000000010003eac", "5e57ab4f000000000100517b", "5f5454ba000000000101fbfe", "5f54f3940000000001002765", "5f5759fe00000000010091ce", "5c06475c6b58b70924592ca6", "5e896aaf000000000100b511", "5ccef8b7000000001703500b", "5bc894ff87637d0001ca88d8", "5e85a4380000000001007dc5", "5f5113e30000000001004184", "5a8c316ce8ac2b64c068c497", "5b6a5097173fb3000152703f", "5e1b278b0000000001001862", "5f200e9400000000010046ea", "5e223dea0000000001008ef6", "5f2a70f30000000001001c29", "5f0d7a0f000000000101f249", "5c10dcaaf7e8b92a99a1533b", "5e856352000000000100a0d6", "5f5ecfd8000000000101db36", "5f4cb6260000000001003f5c", "5c2173c20000000005039e2a", "5c0bbc3000000000060281a5", "5f588a230000000001003740", "5bd32cb1413d0c00010ab258", "5f15947f000000000101cb64", "5c919563000000001100af9c", "5655a2c6f53ee02cea96fb0f", "5c8206400000000012037a8c", "5ef1f6c80000000001006f8d", "57300ae282ec39705a528611", "5a0ba356db2e6078dcf6d43c", "5e74b0180000000001003cdd", "5c6bcdac000000001003efd9", "5c87c3e0000000001001f6d5", "5c2173c20000000005039e2a", "5f05bf580000000001007ecb", "5cc5c9bd000000001602b1c2", "57481c2e50c4b41a927ce528", "5e21394f000000000100767d", "5ee5c1f8000000000101e2f7", "5d27dd7f0000000016035700", "5e11deca0000000001003a75", "57300ae282ec39705a528611", "5b07724511be10167786da2f", "5be4df9d3e045e0001b282df", "5e1b278b0000000001001862", "5ef1ab28000000000101fefa", "5e9fcad0000000000100b825", "5f313dad00000000010028f2", "55f153523397db6a6262a294", "5dde4f5c0000000001002220", "5ef984ff00000000010069d9", "5a15240b4eacab0cb15c3b02", "5b67b656423b0a000154bbca", "5f16511c0000000001006a9e", "5efdeba4000000000101e7e6", "5b801a194dcc060001378062", "5b67b656423b0a000154bbca", "5f2cf62400000000010031f5", "5f1a5a00000000000101e4c4", "5e7f3158000000000100adca", "5f1a4f97000000000101c117", "5a8c505211be1077311f84f4", "5a8c505211be1077311f84f4", "5eaab1dc00000000010020d9", "5f1a83d00000000001000afa", "5f1a40bf000000000100b080", "5d4135060000000012034ca8", "5f193db70000000001002eb4", "5cbc38cf000000001103555f", "5d06ee480000000012033de2", "5d18cd02000000001102d9ea", "5f1bdad400000000010075fe", "5a931fe011be10089d864cd1", "5c737c23000000001102d9c4", "5cb57095000000001603d7d2", "5ac065c011be107a220c6f16", "5f34d3650000000001002f0f", "55c1dc3b3397db785b9efe42", "571bffc94775a70e9838f19f", "5f2f5f96000000000101c65e", "5d4e0f86000000001603c00f", "58836b6fa9b2ed4e1a2fd2b9", "5dbc304a000000000100a1be", "5f3cfc17000000000100b1ca", "5c8206400000000012037a8c", "5f3d20090000000001009d8a", "5f4cb402000000000100373a", "55b8e787a75c9555bc513867", "5c3eb8c4000000000502103b", "5f4758fd00000000010014e8", "5f4647a8000000000100b044", "5c682da8000000001001bade", "576d912882ec390d3d8a62fa", "5f4ca668000000000100885a", "5f4cb402000000000100373a", "5f4cf99300000000010085df", "5f4cb7fa0000000001008a07", "5efc42bd0000000001007d90", "5c1349a40000000005011d91", "5d255272000000001603b6b2", "5cb0a86b00000000110344ad", "5dbbf9db0000000001001115", "5f4f64f40000000001005d7c", "59e92972e8ac2b2cb99f9929", "5bf43a75b29f31000143380a", "5f3f058e00000000010098cc", "5a40dc584eacab033b98bb66", "5ef09b3f0000000001000265", "559562bfc2bdeb12a28c9bf8", "5c7cd2df000000001000ca04", "5cb81b88000000001601f401", "5ed354440000000001004130", "5759663ea9b2ed75497202b5", "5e08677200000000010096d0", "5dd7b705000000000100b451", "5db8f80700000000010015d6", "5bbc8951d54a8800014afa7f", "5ea2a81c000000000100997e", "5dbacee00000000001008735", "5bc1c712b891c30001b16d28", "5f2151ea0000000001000841", "5c271038000000000700132f", "5ec15f790000000001005da1", "5b3370a2e8ac2b4fa86d5e41", "5f252bc000000000010041f0", "565832fca40e185abf7099d2", "5ea2797200000000010009a2", "5f5b0da2000000000101c3fb", "5f5b0c250000000001005bc6", "5f5b0efd0000000001002de1", "5c0e1f9e000000000503e71a", "5b6d05af6b58b77dd733f22e", "5f4f991b00000000010048a5", "5f5b1e2b0000000001001a01", "5f6042c9000000000100a59d", "58c7bdfd6a6a6962a54086d8", "5dfb8dfa0000000001009797", "5b17ffb911be102d47275d2b", "5e100c0000000000010024c4", "5b6661f33af703000177667d", "5837eced50c4b4557f25298a", "5e807bc60000000001008f62", "5ee1d0dd000000000101d533", "5d6b2b700000000001002c37", "5f5f2e37000000000100a7c1", "5e92a01b000000000100890e", "5c6231ec000000001b02b640", "5f1573ad000000000101e057", "5d1c1d5b000000001601a777", "5b7b7a2de6c0620001e2d867", "5c71f9f100000000100201e8", "5ea6531000000000010050ea", "5f51f765000000000101fd97", "5b9a123aad30410001092ac2", "5c49e87000000000100164fb", "5ebe29160000000001003aca", "5dce68c00000000001007bbc", "5ce77d41000000001602a7bc", "5cecb52f0000000011017140", "5bc069b46429b8000115705e", "5bc068e4ed57ab00019649cd", "5bc06aba51b1720001b5152f", "5bdc0b2b73d5f80001cbb3f6", "562305fca40e180a032cfa3a", "5df0528d0000000001004320", "5482c7732e1d932edbaad9b4", "559b936562a60c200b042137", "5e83e0a50000000001008ac8", "5f641a96000000000100806f", "5f641b8b000000000101d82c", "5f641f3d0000000001008f32", "5efb3494000000000101ea69", "5e856352000000000100a0d6", "5c9989490000000011009bd8", "5ce5201800000000180173bb", "5c78fd850000000012016ac4", "5f65b2a5000000000100a97c", "5e7810000000000001004d00", "5aede882e8ac2b7b1bd3d42e", "5c9617f5000000001100ecd1", "5f682dee0000000001006b15", "5a95127b11be10411367fe8d", "5f5092fe00000000010005da", "5f684f4a000000000101cbee", "5f293f56000000000100896a", "5f685ab900000000010075f1", "5f674d5c000000000101eb45", "55898378874dfa5bf980ef15?", "5ce3c41a00000000110042ae", "5750d1b7bd0da54fb3b5aed1", "5f2a32360000000001005d1b", "5f696b8d000000000100a5b8", "5ef549c40000000001004757", "5e6ca18100000000010029b1", "5f02feed00000000010039d3", "5dafdf700000000001001443", "5b862239b8134000014d1507", "5f3247f1000000000101f669", "5c85bd8d0000000010016728", "5a980dd5e8ac2b3b9840b1f6", "5c68bf280000000012038803", "5ad4b3db4eacab684843ac8f", "5b9d313962e5f700018749e6", "5d2d959f0000000012007d94", "5e9ab16100000000010022c2", "5b5ff06211be10495ab7b0d9", "565bcb5be4251d340b8af3fa", "5a46044d4eacab1cf11f55e9", "5cb9ee710000000010003eac", "5af4198f11be103ce7f9cc21", "5ae03090e8ac2b03c5a8b318", "5e8184450000000001005885", "5e0c792a000000000100bd00", "5b41bfd06b58b7593f2275e4", "5bc9f2495469660001d38d1c", "5eba63430000000001007e6d", "5a5d657911be1018e02db452", "5e1177ff0000000001008896", "5df2e5e20000000001006edd", "5e56e8350000000001007377", "5d653119000000000101bd4b", "5e9da85e000000000100bf7c", "5b63ef3b3f7bc000016d73ea", "5e998466000000000100881d", "5b103c9e4eacab2cd61503ac", "5ef534c3000000000101cdb5", "5c979e0e0000000010000572", "593a4b4c82ec39640f945385", "5e3ce6fb000000000100bad7", "5df79b220000000001006323", "5569b1ada75c9501dd0417ba", "5be6ce2f954c810001dac8bc", "5f17ee4200000000010068bb", "5a314e364eacab7fcb811a37", "5db67f350000000001000579", "5c1b0c0e000000000502248e", "5d24bcb90000000010031e5e", "5e65d1ad000000000100285d", "5bb0f870e2b1da0001e2d40a", "5e7e24e300000000010075ce", "5e9b18ee000000000100be77", "5e9d1c65000000000100b189", "5e0305fb0000000001001bba", "5d3bab32000000001003ff88", "599c01ba50c4b4187cd6681a", "5f4f5ced000000000100aede", "5e08d24c000000000100a293", "5b2da4a46b58b7038bbd7af1", "5f3a080b00000000010038e3", "5adaff56e8ac2b3b9c297661", "5c89c0c10000000011025c62", "5c877ed3000000001601a684", "5b1bf26511be1078aabde77d", "5de1468f0000000001002779", "5b7a6bf93da56a00016ad212", "5f1d928a00000000010020dd", "58c53d1682ec39317032a791", "5d43fd50000000001003df66", "5f56eebc000000000100bce1", "5ef55bae000000000101d062", "5d2edd3c0000000011009f3e", "5d0f6a6e0000000010003c17", "5f5898040000000001002484", "5d04f154000000001003e04e", "5f589499000000000101cad7", "5c094c03000000000600d7b3", "5b53ac8d11be106299a439da", "5f5b16450000000001008929", "5f5b834c00000000010091c5", "5c41ef640000000007019c8e", "e31850a0000000001009397", "5d8449af0000000001008104", "5b756a48afa6e00001cfb2fd", "5961ff006a6a694ee5475a5a", "5cf32c91000000001001a531", "5f623bc6000000000101f82a", "5f33a309000000000100761c", "5f1708970000000001007f22", "5f365fad000000000100076e", "58db898550c4b40fded8e7f3", "5f4b4498000000000100a1e9", "5b827b9a62c4310001266240", "57988daf50c4b43ba44c65dd", "5ea6542c000000000100b3d8", "5f1ef787000000000100000f", "5edf2816000000000101c28c", "5b67a6de4b52380001fa44d4", "5c46cfad0000000011031581", "5f28f4bb000000000100bae2", "5f25672e000000000101ebe7", "5e1afa4f00000000010080c9", "5f200f7c000000000101e935", "5a324e9fe8ac2b2d8f421abc", "5ef4626c0000000001004d3d", "5dec8a3f000000000100bf58", "5d5109e30000000010028a12", "5f27a5f50000000001005ccd", "5f3b8c2800000000010032eb", "5df9ee4a0000000001001e3e", "5c061a85000000000601d1ad", "5f3ce63c00000000010050c0", "5c4701b3000000001203cf1d", "5f44818f000000000101c49e", "5588340b352da57f917d6e62", "5f4c832e0000000001004fc4", "5f4f15860000000001004838", "575bbaeb6a6a695c7f730c9b", "5cf4a7300000000012004b15", "5f3762a50000000001005689", "5f4b5bf80000000001007586", "5f4de4800000000001002794", "5f5103b8000000000100b018", "5d5c050d0000000001004802", "56c89e4e1c07df177fcaa0c1", "5f560c410000000001006e6d", "5f292de1000000000101f950", "5f5726b4000000000101c1d3", "5b19363df7e8b96a655a3cdc", "5f5ed135000000000101decc", "5bb5ab6118e5970001e9132d", "5d196096000000001101bd36", "599d80f182ec39400ff732d1", "551ea4e79c5a6e775a2ab3f7", "5a573c5411be103277fe0d99", "5b109db711be10195c2be549", "5f437e3800000000010057a4", "5ed5e2da00000000010013a9", "5f0ec8ab0000000001005e02", "5ed2238e00000000010005b2", "5f607530000000000100a967", "5ed22141000000000101e3a2", "5f10378e00000000010021e2", "5ed210560000000001001e12", "5ed223b6000000000100067c", "5afeff2711be102fb1be0a6f", "5f60ea43000000000100ac5b", "5be2f4af03076000012b1234", "5f60c306000000000101c4c7", "5d8ae6140000000001019f2b", "5f2d71c900000000010072e4", "5f623d650000000001007b00", "5c7550c20000000012028f7a", "5df6e67a00000000010087d1", "5bc79d2a4126c30001edb08d", "5c80fbc5000000001100481f", "5f6336c4000000000101f00b", "5f696b8d000000000100a5b8", "5c909bdd000000001002b43a", "5c909db3000000001002b873", "5c7cb1ec0000000011035aea", "5e1ad366000000000100aa9a", "5757e2466a6a6967aab32ead", "5f15006b0000000001006e66", "5ef5538d000000000101eee4", "5e2c125e0000000001004659", "5c4fa4900000000011023202", "5e97e22b00000000010007b9", "5efacb7c00000000010072df", "5e16c852000000000100240b", "5d1d95ad000000001600fe61", "596eedc66a6a6929c4207732", "5ef8724500000000010047a4", "5b0bb4704eacab13ca2cd0f1", "5ba5a9e18911af0001200397", "5634ece5f53ee077e26f98df", "5b99c1e7fed5d30001f65fe3", "5f09ea51000000000101f5af", "5cb3003b0000000016023346", "5e16de7300000000010090be", "5d07bab4000000001603a319", "5c7aae2600000000120164e1", "5bc012924c79990001d9ce19", "5b7e2f6e3f9a570001d91905", "5cd052a6000000001001cd3b", "5ec773b500000000010049cd", "5e5073db000000000100aa64", "5899d8ba50c4b425bbd86e0d", "5efc569400000000010037a8", "5bb4b3959cb8ac0001202f64", "5b7a81d270408d000127e08b", "5e53d7dc0000000001009890", "59fa9123e8ac2b4e0768e03a", "566d5213589de33633cc579c", "55d73deb3397db2450fcaf3c", "59270ae582ec3931265cfa0f", "5eef52ec000000000101caa5", "5ed49bc900000000010073c9", "5cdbbe7b000000001601bf72", "5e6647850000000001000cf2", "56c5a405aed758147c6927c4", "565a315f0cdc2b0360354325", "5e877dd40000000001008a80", "5e723dce000000000100245c", "5c27f458000000000702885b", "5ced513d0000000005013d54", "5eb61afc00000000010065e4", "5ce141d800000000110119aa", "59ba080382ec3956980d2a1c", "558fb43ce4b1cf087de3dcc8", "5f2b699d000000000101f726", "5a8e4a294eacab78e1d488d5", "5f40e9290000000001003e6c", "5a4382f14eacab0b1f070005", "5e94934a0000000001009103", "56cc17596a6a69228e384452", "5b1fa9a911be1024c8d079c8", "5e369b7a000000000100bc39", "5ec4d118000000000101f980", "5a572530e8ac2b4dd262cdcd", "5f227150000000000101e4a0", "5f1e86a3000000000101e8c9", "55730ff73f0f3c074f59302b", "5f2a52b80000000001005b31", "5f2107b8000000000101e5d1", "5d7a26e00000000001019ac8", "5f0bcabb000000000101d4ea", "5f18f7c4000000000101eea8", "5a61ff8d11be104983fee2d0", "5d283d930000000016017524", "5ee827c7000000000101d4f2", "5ed749e9000000000100467b", "5f3c978500000000010068d7", "5ea0fe42000000000100b52e", "5d9d4f480000000001003ecb", "5edf4d9f000000000101d2f8", "5cd4ecf60000000011001b9a", "5955d3c850c4b438a92fefbb", "5f33cf0e0000000001002e2d", "5e3d2087000000000100a96e", "5eb23563000000000100579a", "5eb53d1b0000000001006506", "5c0cc2630000000007039bb3", "5e90e6120000000001009eed", "5b1531856b58b732dcf0afaf", "5e4b31620000000001009763", "5c8757c3000000001100524e", "5cdd4628000000001700b112", "58a81f4982ec394520364e1e", "5c9777e60000000011005cdc", "5daffa1c00000000010047ee", "5e5c73160000000001000e3e", "5d2ef7b00000000010019106", "5dd63dfe0000000001000730", "5ecf6177000000000101ff9c", "57d6bb7f82ec3951c2ad6b32", "5ca5de690000000017001481", "5d88534f0000000001001925", "5bb19634bb1c7400017f5f61", "5c20dd620000000007027d1a", "5cc812750000000011010905", "5ed93e9c000000000101fcd5", "57c2551ea9b2ed0a76394f2f", "5efc9c9c000000000101dfc3", "5e32c2080000000001006694", "5e817e350000000001004365", "591d51c16a6a690afa201fab", "5bd13690cccf7c0001256aec", "5d0858930000000012006281", "5ef9f42e0000000001001194", "5c68ceaf000000001203da9c", "5b71b91691ad890001c52abb", "56480e6be00dd868e98129f0", "5f29546a000000000101ccfc", "5cf09db000000000100189d2", "5e58ac0a000000000100286f", "5ea926a8000000000100b9f5", "5c7aa42b000000001603baa4", "5a44bf884eacab7e85c9118f", "5f0094cb0000000001007691", "5c2dff70000000000603aba9", "5f225b3f0000000001006d40", "5cec9e6a000000001702e064", "5ed0ad6b0000000001000949", "5c7e77bd00000000100267c6", "5e1348fe000000000100af29", "5c10f1f3000000000702a634", "5e25440f0000000001006ed6", "5bfa55b6e0db840001d8471f", "5e0224f40000000001000b14", "5dfaec19000000000100ab56", "5a35dbf7e8ac2b327ff92068", "5f2926d90000000001007411", "5986dde45e87e73e0fbd3364", "5af5894ff7e8b9060709f421", "5ec9f85d000000000100762f", "5b3dcf3de8ac2b33251c3adf", "5ce26c490000000016002ade", "5b5fdbb56b58b70a81a2c2e3", "573dbb7a50c4b43d3b712a15", "5f1001ab0000000001004873", "5f3023ec000000000101d1f8", "5cfde66a0000000005011c8d", "5f44ce3e000000000101c817", "5f338a880000000001008cfc", "5e107f4a0000000001008e4c", "5dd5e9220000000001005df4", "5ef5c678000000000101f2ae", "5c57da40000000001802856d", "5b7b0ff34d5c2f00011f1c17", "5d007c3e0000000011001605", "589d35b75e87e7644db1aea2", "5b94867c687e0300012ddba4", "5e7f6a670000000001000bdd", "544b9d5fd6e4a977dde606b9", "54ff9ae54fac6356d91f335a", "5a324627e8ac2b19622025be", "5f2f9f09000000000101d808", "5f377a30000000000101e57a", "5f084dae000000000101c88f", "5f17c4ca00000000010052d9", "5f26f2fc0000000001006155", "5f3fa84d000000000100aeb6", "56236486a40e182e62b21f46", "5aa44696e8ac2b615564e534", "5e5386fb000000000100aa4d", "5d20ba850000000016000f40", "5e4e5da6000000000100b123", "5a03f6414eacab6f7f8d9bc3", "58f6e5825e87e76ffe546775", "5f50834500000000010069e4", "5f5839c2000000000101c0bd", "5f58754700000000010075ac", "5f688e9700000000010041ed", "5ce3c41a00000000110042ae", "5f684f4a000000000101cbee", "5bcacc1c9007ec00010c5861", "55898378874dfa5bf980ef15", "5c75360e000000001201f2d2", "5e54ba250000000001005065", "5dd341a70000000001003f17", "5f51afd40000000001009dc7", "54e1c568e7798962516effac", "5f1a5b7b000000000101eab8", "5f6c93230000000001002c58", "5f3d30b3000000000100bb45", "5c45e76c00000000110053c9", "5ee88ba6000000000101df56", "558e6d9867bc654edcb73827", "5f6accaf00000000010057a4", "5f6ac92f0000000001008532", "5f6a88050000000001009bb3", "5df971ac000000000100351e", "54589bb2d6e4a90a2ee65442", "56778f47b8c8b43c34c0b77e", "5f2a8b9e000000000101c34d", "5ea4f0f900000000010014cc", "5f2f762e0000000001009a89", "5bd9b78f19326900016e3934", "5ae9b965e8ac2b0ca2a41d5d", "5eb8fd5100000000010013ec", "5f6d67b2000000000100a2e9", "5f6d8750000000000100bd29", "5cf12c09000000001701b54e", "5c46d84500000000110335c6", "5dc8ccd4000000000100b584", "5b2bc7b6e8ac2b4bb1b41318", "5f6c07280000000001001ff5", "5f6b43e200000000010044e1", "5c792d58000000001201edde", "5c46d84500000000110335c6", "5f642455000000000100084e", "5f641b8b000000000101d82c", "5b7670bb4722e20001731bd7", "5c890bdf000000001601f1cf", "5f4659ab000000000100200b", "5a1d06b74eacab172397782a", "5b1508764eacab5e1f612ef2", "5f41f3c7000000000101d434", "5f700e3b0000000001004e3c", "5f6c115d000000000101e9dc", "5c18603b0000000005034a28", "5b191ab04eacab379400c50c", "5ed0e484000000000101d9cc");
    // 0929 出行
//    private static List<String> newUserList = Arrays.asList("5f33338f00000000010008bd", "5f590510000000000101f5d8", "5c682726000000001202083d", "5f51d71c0000000001000fa9", "5f4dbbe8000000000101c555", "5f4dbb4e000000000100633f", "5aa17c9a4eacab36de139ba9", "5f5edbc4000000000101fcf7", "54e5a9fd2e1d935fe1851825", "589af47182ec390b631a82c8", "5f53380b00000000010083d7", "5b8fe7a9766d1e00013c16c6", "5eab959100000000010038d2", "5953019b5e87e767d1d3e41e", "5bbc1024918acb0001a8a08c", "5b12e99111be104d2d8ea567", "5cb820e4000000001003be1f", "5d597b980000000001018a5c", "5d4d29de0000000016019795", "5f603280000000000100a8f5", "5dafb1020000000001005d1a", "5c8295740000000016009955", "5f505c8700000000010008c8", "5a1792534eacab4036d7c38c", "5b77e6da3da56a00019f7448", "5cad9a70000000001601b56c", "5e8150a1000000000100bbe7", "5f6091cf0000000001006355", "5b87827d987fc900013b36ee", "5f61b527000000000100068d", "5a71275011be102a9e773d90", "5ea142cb0000000001003ea4", "591216e16a6a6958862b4247", "5ad402b311be10786596c590", "5d4251e1000000001101fed9", "5b76ed876b58b7618e8970cc", "5dd54ce80000000001000c06", "5bc84bb2e1b29d0001d36dce", "5c8c9d00000000001202da42", "5b217d7f4eacab7dfd8a0d24", "5cd3d1f3000000001202e4af", "5e7c49220000000001000a47", "5efc2b47000000000101c22a", "5cd2798f0000000011029ab9", "54e4d1cce7798967d62f7c39", "5d01e4b40000000012017ea5", "5bac562b8abbba00011ef6e6", "5ebb749c0000000001004651", "5b8d112d0155ff00015962c5", "5d148a97000000001200a38b", "5cc7e8810000000017027853", "5aa143c311be1003531060cc", "5f22a1760000000001004993", "5ad485ba11be10455a4385df", "5bfa2ea3e0db840001bc61b6", "5bf81245d6d2cd0001ffa02c", "5f6210e50000000001003576", "56440b44e00dd85cb032bfce", "5b57c79a4eacab18b06765e0", "5882267d5e87e707d5602905", "5a2bfcbe4eacab3a33693504", "5cc1bbdb000000001600b6f7", "5e8eb26b0000000001002684", "5cb97a38000000001202c76c", "5a680e6a4eacab569311b280", "55a4f1ff58944640664fe7dc", "5ba1e2502bdb21000168e1af", "5850eb796a6a695916914b25", "5a698640e8ac2b06169cc513", "5c25b2bc000000000700ecd8", "5a4ca35fe8ac2b41c2e82964", "5ca21b8e0000000017000bd6", "5bf9ff7e999837000189d106", "5d79a318000000000100899d", "5b82d4205424e20001b46950", "5dd784630000000001003a90", "5df7d83c000000000100af40", "5ba1fdf7aee1a2000142c0d7", "5571cb3e3f95a30a4dbe2ee1", "56d92e911c07df64fdb931ec", "5bf7651ebc63640001cbd6e4", "5524ace52e1d937e5564fffc", "5efc03c6000000000101f436", "5bfa5e1ce0db840001de9fe1", "5c4420eb000000000603043f", "5c270255000000000703e779", "5ece445f000000000101cafb");
    private static List<String> oldUserList = Arrays.asList("5501b7bda46e9667b4a8f7e1", "56585ef8e00dd87ff58fdbd8", "566ae0e050c4b472ce971b00", "582db5c25e87e7642ffa7d68", "5970495050c4b440fab52a1e", "598e761d50c4b41a11be11c4", "5a1cdecde8ac2b703b648c13", "5a1ff08e11be102c3ac9183e", "5a52cc7111be1053a77bb537", "5a64aab811be106cfd490ce1", "5a7ef5db4eacab544e374f2c", "5a991a07e8ac2b36adfa173e", "5a9d4bde4eacab4a1e69b3c4", "5accdffa4eacab4a84b2ee60", "5af5977e4eacab7d9f302b73", "5b0d6bc611be104d5db63582", "5b2992634eacab381cdb94d3", "5b62fbcd4eacab4754d780ac", "5b691ef96223e8000108e73e", "5cd7bbf30000000012032009", "5cf1fd44000000001602c2bb", "5cff5b5e0000000005001da2", "55f25bae67bc654e97a43517", "56567820a40e18211b66270b", "57e90d345e87e7672dbc0126", "59c4e62044363b1f919ea8f6", "5a0bd59d4eacab2b34fc9999", "5aaa6c32e8ac2b421f64bd26", "5abf65bc4eacab16cc2d7c60", "5ade11804eacab30bd498ec0", "5b13ef5311be104a07b60733", "5b334b234eacab26903de265", "5b6fb8d9e1a9100001b425af", "5b7b715e4452b50001b88efb", "5c04bf7d00000000080122c8", "5c8b8d820000000016039cdb", "5cfe2136000000001600a47f", "5d08dbe7000000001003f7b7", "5dde1a0c00000000010043d5", "5e5df4700000000001003d45", "5e673bec000000000100b6db", "5e6cb0f40000000001005ba3", "5e8ce8f000000000010091db", "5e9e99370000000001002746", "5eb67e710000000001003249", "5ed75ecf00000000010031b2", "5f18fe17000000000100a54f", "5f3a5fdd000000000100155f", "5f3c753a0000000001002bc5", "5695301584edcd28ee6a4b58", "569a067582ec3901e3f5a574", "56f48dd64775a76d196e75a1", "571e4d7b4775a72c989ec258", "59fe7cb6e8ac2b5590936a2b", "5a5c1b2be8ac2b63134d3c4e", "5add59f44eacab5ca661dbda", "5b0acb7f11be101b5abd52c8", "5b179f1911be107ea127e0ae", "5b65d200837bda000134e08b", "5bb0f51224c69400015211f2", "5bf2828720f63200012c055f", "5c3afbcb0000000007024179", "5c8221fd0000000010029a61", "5cadc3f00000000016021606", "5cb7ed4b0000000016017f9d", "5cc011fa00000000170230fb", "5d0a011c000000001202ccc6", "5d0c1cbd0000000010030ade", "5ed0839f000000000101f4d5", "57a59948bd0da56427d9e5f4", "5aca2751e8ac2b04b584339f", "5b88feb667e1e100016e8bbe", "5b97f213df4ce100019bf2a6", "5ba0c5facf71270001f11352", "5bdbc7a5a1c0130001c2a1cb", "5c02b0080000000007002154", "5def2d810000000001003fd9", "5e460ff40000000001006a2b", "5e59f9080000000001004aad", "5e6757ef0000000001004aa8", "5e686ea20000000001007bc7", "5ece5fc00000000001002f82", "5eea43da000000000101dd82", "5f0ea3bc000000000101c742", "5f15825300000000010076db", "5ce391ee0000000010020980", "5cf967d6000000001702f9ee", "5dda7dcd000000000100742a", "5eec1e670000000001007602", "5f0ea3bc000000000101c742", "5f3df5450000000001002525", "5f584a880000000001007c30", "5f519e69000000000100a42b", "551a33a8a46e965850b41a9d", "556a7c6dc2bdeb6d18277f4b", "5623a18b9eb5781859222bbf", "5657153982ec39153a818cf0", "565d826c7c5bb81ed3450cc9", "5700ef6d4775a73727f29141", "5721fc081c07df59c1d9520d", "573ab24a50c4b4487650bbec", "574cf9f33460946d6b36adf8", "5825b0e282ec39348b356950", "58569f3982ec397c2ad6b86e", "589883176a6a691cdff0752f", "59376db550c4b40340323c39", "598fae1e5e87e76daab899a7", "59b246ed50c4b41e3b6110d2", "59bb90a750c4b4667136f89a", "5a51c9dc4eacab78eac54bb0", "5a8042994eacab706d6b0888", "5a9422a64eacab50a3f3483e", "5aa3f27ae8ac2b42f8fdcb3e", "5aaa65994eacab525f0c8647", "5adcc39b4eacab144613a09b", "5ae9c5cfe8ac2b13d4a8788f", "5ae9eb204eacab26b53acae8", "5b1cb3aa4eacab601e6d2066", "5b98aa6c6b58b737168820f8", "5bb77f7271e9a00001d6f0c4", "5bdd960b1a3f5a0001ef5b80", "5c4a599600000000110190eb", "5c715227000000001200ce10", "5c78cb4d000000001200e577", "5d0226fc000000001202eb8c", "5d1cc932000000001001983a", "5d8c783e0000000001001a9f", "5dd4d66f0000000001007af4", "5e5cea7e0000000001003b8f", "5ec2536c000000000101e3df", "5efda7c8000000000100103e", "5f1024560000000001006bac", "5f4e11470000000001006601", "5f05337c000000000101f0e6", "5574490b24caa93465976e16", "587977555e87e7654b51083c", "59a6771d82ec397675fa4714", "59c4553344363b2f5db1e212", "5a1614fa11be104d833a609f", "5a5b08b1e8ac2b7140f3e9a1", "5b71888b6b58b77f47189ea1", "5c519c9c000000001b025a17", "5c971a220000000012036865", "5cf967d6000000001702f9ee", "5d847f7e0000000001005ea8", "5e04baa70000000001002708", "5e8589bb0000000001002957", "5ea2d3040000000001003391", "5ed89b140000000001000178", "5edf62a7000000000101eb5f", "5ee03d4200000000010059f5", "5f12f46f00000000010061ae", "5f1fa74f0000000001003eef", "5f2e2df3000000000100a2d5", "5f3a449a0000000001009a24", "5f3a4d91000000000101c460", "5f45edab000000000100aca7", "5f45f44b0000000001004445", "5f461fd40000000001006938", "5f462011000000000101f16f", "5f46367b0000000001003d97", "5f479a230000000001002d5f", "5f49d61f00000000010094e6", "5f4b8b1a000000000101d800", "5f4cdd240000000001001427", "5f4f01ef000000000101e33c", "5f4f032c0000000001004b5b", "5f4f70e10000000001004db8", "5f4f719b0000000001008039", "5f4f737d00000000010003ec", "5f50c2d30000000001005627", "5f570a73000000000100711e", "5f5719a7000000000100312b", "5f571d9f0000000001006dd1", "5f5722c90000000001009eb9", "5f5753fa0000000001005e93", "5f58b06b000000000101f50e", "5f5a4a71000000000100018f", "5f5b19530000000001009301", "5f5b2e7500000000010010dc", "5f5b3fbb0000000001000f35", "5f5b47180000000001002d9a", "5f5b52fe000000000100a1c0", "5f5f084e000000000101c148", "5f5f2d0a000000000101f516", "5f5f5fb4000000000100701a", "5f5fb3df000000000100008b", "5f60876c0000000001002bff", "5f61a740000000000101e58f", "5f6309f9000000000101c08b", "56d0572484edcd258ca32ea1", "58b28d4f6a6a69257215ceaf", "5a01c9f4db2e600528f6d4a3", "5b45c5386b58b74d069e7b1a", "5b863655808f4d0001c1172e", "5be057c61e84f90001b3c114", "5c2e48c6000000000702e67c", "5c610231000000001a013486", "5c7e68970000000011014aa4", "5c8d38d1000000001200c8ca", "5c9815e7000000001201a5b3", "5c9ad4e6000000001102cdd9", "5c9f42ea0000000012032ab6", "5cafe86c000000001702e3fd", "5cc55c45000000001601645b", "5d1aad950000000010031d4c", "5d66505d000000000100404b", "5e1952eb0000000001002f75", "5eae18640000000001005abe", "5f0a7cb5000000000101df43", "5f0ff99b000000000101ee12", "5f3cea6e0000000001009873", "5f3faf74000000000101db59", "5f5753fa0000000001005e93", "5f59ca630000000001004ce5", "5f59e6a7000000000101fdda", "5f5b06ab0000000001009792", "5f5b08b0000000000100515b", "5f5b6a2b0000000001001334", "5f5b8e5a000000000101ec0f", "5f5ef0910000000001002149", "5f5f342b000000000101cf94", "5f602f6d0000000001009d40", "5f6060fb0000000001001013", "5f6066d9000000000101fff8", "5f616a230000000001008d4b", "5f618887000000000101fdac", "5f6304ad0000000001003d39", "5f670bb7000000000100810b", "54917ce5e7798917057d71ad", "54bf14612e1d931488e4f39b", "55065dd9d39ea206e65fd13e", "566ec825b8ce1a0354bd85a9", "576298ed82ec397c57771ffa", "590f32756a6a694347fbb63c", "591cd18350c4b47050eff083", "5987114d5e87e72e02bd32df", "59b6adfe82ec3962d41b843f", "59ca389a51783a646e27b331", "5acedaf811be1019e01eda7c", "5adb4ff24eacab6df28b2383", "5b1491cb4eacab1dc51370f2", "5b1cb3aa4eacab601e6d2066", "5b54634c11be104155dc60d0", "5c178b0c0000000007014b92", "5c233ba1000000000503c08c", "5c4a599600000000110190eb", "5c643d550000000011017ec5", "5cbd2b7b0000000010001557", "5e396bdf000000000100a47f", "5e4d2cb600000000010048f0", "5e4e1e930000000001005a19", "5e7f599200000000010098b6", "5ea444db0000000001009a8a", "5ea7b35a0000000001000347", "5ec4a589000000000101c612", "5f05337c000000000101f0e6", "5f1978340000000001003ff4", "5f46086d000000000100976c", "5f5b27bf00000000010039fd", "56507c939eb578248b3ca71d", "5a314e364eacab7fcb811a37", "5a572530e8ac2b4dd262cdcd", "5a92a8e4e8ac2b1a7db9d88d", "5b041837f7e8b92fa3c4203d", "5be7a649e85ef00001e012b1", "5c10dcaaf7e8b92a99a1533b", "5c4701b3000000001203cf1d", "5d4e0f86000000001603c00f", "5d5109e30000000010028a12", "5d64ec370000000001006277", "5df79b220000000001006323", "5e21394f000000000100767d", "5e3d0a9700000000010089e4", "5e6647850000000001000cf2", "5e9efa980000000001003d03", "5edf2816000000000101c28c", "5ef984ff00000000010069d9", "5efa6253000000000101c328", "5f1d928a00000000010020dd", "5f1ef787000000000100000f", "5f1f9b990000000001004093", "55f153523397db6a6262a294", "5655a2c6f53ee02cea96fb0f", "57300ae282ec39705a528611", "57481c2e50c4b41a927ce528", "5771e1185e87e74a3f70927a", "57a1a19182ec3926357da1f8", "58fd6d5250c4b42332a4027a", "5981b4e950c4b4369e4a2785", "5a05c4fa4eacab6ae23b7e61", "5a0ba356db2e6078dcf6d43c", "5a4231044eacab7d8ff1e91f", "5a8c316ce8ac2b64c068c497", "5a94e67de8ac2b2bed6a6729", "5aa5c2904eacab2a4039070e", "5ad2b92f11be106226d7c241", "5af2eb354eacab39393b6554", "5b07724511be10167786da2f", "5b28f85b4eacab71d4e84ddb", "5b2afdf311be104ac3c22931", "5b422a0311be106ec0b739c0", "5b463a7711be10622c103cc3", "5b487eb911be100837411550", "5b5af7b0e8ac2b2428e4fe8f", "5b66766e06825b0001d0854d", "5b6a5097173fb3000152703f", "5ba5f73def996a0001f06363", "5bc825aa2ace7700013535ad", "5bc894ff87637d0001ca88d8", "5bd32cb1413d0c00010ab258", "5be4df9d3e045e0001b282df", "5c06475c6b58b70924592ca6", "5c09505a00000000050149e7", "5c0bbc3000000000060281a5", "5c0e752b51783a23c257d705", "5c10dcaaf7e8b92a99a1533b", "5c2173c20000000005039e2a", "5c3f40080000000007009a64", "5c6bcdac000000001003efd9", "5c7aa42b000000001603baa4", "5c8206400000000012037a8c", "5c87c3e0000000001001f6d5", "5c919563000000001100af9c", "5c98773100000000100178fb", "5cb9ee710000000010003eac", "5cc5c9bd000000001602b1c2", "5ccef8b7000000001703500b", "5cd14bf00000000012026828", "5cfb8d24000000001602e972", "5d27dd7f0000000016035700", "5d5644ef0000000001008852", "5d746c7b0000000001002e27", "5da719be00000000010017fd", "5da81cda00000000010022ab", "5db8f73e0000000001006454", "5dbd1ca3000000000100187e", "5e11deca0000000001003a75", "5e151a210000000001009a34", "5e1b278b0000000001001862", "5e21394f000000000100767d", "5e223dea0000000001008ef6", "5e57ab4f000000000100517b", "5e672e710000000001005d60", "5e74b0180000000001003cdd", "5e7eab3c0000000001007a30", "5e8033dd000000000100b995", "5e856352000000000100a0d6", "5e85a4380000000001007dc5", "5e896aaf000000000100b511", "5e920b3d0000000001000594", "5e9fcad0000000000100b825", "5ee464330000000001003810", "5ee5c1f8000000000101e2f7", "5ef1ab28000000000101fefa", "5ef1f6c80000000001006f8d", "5efa6253000000000101c328", "5f05bf580000000001007ecb", "5f0d7a0f000000000101f249", "5f0d7a0f000000000101f249", "5f15947f000000000101cb64", "5f200e9400000000010046ea", "5f2103e1000000000100a7b7", "5f22c6f8000000000101d683", "5f2940b6000000000101e724", "5f2a70f30000000001001c29", "5f2e64a300000000010003c5", "5f313dad00000000010028f2", "5f323e880000000001008587", "5f45cec90000000001009604", "5f4cb6260000000001003f5c", "5f4fb8af000000000100b161", "5f5113e30000000001004184", "5f5454ba000000000101fbfe", "5f54f3940000000001002765", "5f5759fe00000000010091ce", "5f588a230000000001003740", "5f5c2aa90000000001004133", "5f5ecfd8000000000101db36", "5c41ef640000000007019c8e", "5cf4a7300000000012004b15", "5d8ae6140000000001019f2b", "5df9ee4a0000000001001e3e", "5e9b18ee000000000100be77", "5ea6542c000000000100b3d8", "5f17ee4200000000010068bb", "5f3a080b00000000010038e3", "5f3ce63c00000000010050c0", "5f44818f000000000101c49e", "5f560c410000000001006e6d", "5f5726b4000000000101c1d3", "5f5b16450000000001008929");
    private static String insertFormat = "insert into table redalgo.algo_rocket_support_user_info ";
    private static String selectFormat = "select \"{user_id}\" as user_id, map(\"operator_name\", \"{operator_name}\", \"create_time\", \"{create_time}\", \"type\", \"{type}\") as extra_info ";
    private static String union = "\n union ";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Set<String> newUserSet = new HashSet<>();
        sb.append(insertFormat);
        int index = 0;
        for (String newUser : newUserList) {
            if (newUserSet.contains(newUser)) {
                System.out.println("duplicated user " + newUser);
                continue;
            }
            newUserSet.add(newUser);
            if (!oldUserList.contains(newUser)) {
                if (index > 0) {
                    sb.append(union);
                }
                sb.append(selectFormat.replace("{user_id}", newUser)
                        .replace("{type}", "出行")
                        .replace("{operator_name}", "大春（王春杰）")
                        .replace("{create_time}", sdf.format(new Date())));
                index += 1;
            }
        }
        System.out.println(sb.toString());
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n" + index);
    }
}
