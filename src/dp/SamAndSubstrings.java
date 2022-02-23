package dp;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    //private final static double MODULE_VALUE = Math.pow(10, 9) + 7;
    private final static long MODULE_VALUE = 1000000007L;


    /*
     * Complete the 'substrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING n as parameter.
     */


    public static int substrings(String n) {
        System.out.println(Integer.parseInt("2147483647"));
        System.out.println(Integer.MAX_VALUE);

        //Set <Integer> set = new HashSet<>();
        List <Integer> set = new LinkedList<>();

        for (int i = 0; i < n.length(); i++) {

            int currOuterInt = Integer.parseInt(n.charAt(i) + "");
            set.add(currOuterInt);
            StringBuilder outerString = new StringBuilder("" + n.charAt(i));
            for (int j = i+1; j < n.length(); j++) {
                Integer currInnerInt = Integer.parseInt(n.charAt(j) + "");
                try {
                    set.add(Integer.parseInt(outerString.toString() + currInnerInt));
                    outerString.append(n.charAt(j));
                } catch (NumberFormatException e) {
                    break;
                }


            }

        }

        System.out.println(set);
        long total= 0;
        for (Integer i : set) {
            total += i;
        }
        System.out.println(total);

        return (int)(total % MODULE_VALUE);
    }

}

public class SamAndSubstrings {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String n = bufferedReader.readLine();

        int result = Result.substrings("630078954945407486971302572117011329116721271139829179349572383637541443562605787816061110360853600744212572072073871985233228681677019488795915592613136558538697419369158961413804139004860949683711756764106408843746324318507090165961373116110504156510362261390086415758369311946617855091322330974469225379475157034653986221430086928768825350265642050874148148762850633380318092218497923938934331494944977897218250062378381926065651168047990017214673422724320097123140849040864223795967322521445859865961967502883479331506850337535224430391571038073324911164139663006137417510539192705821435391823658411385338369730232377028300695738866310468334377735439392551346134885024889217010755804062396901380184592416137322133531990680941959600864409332647120219490414701983979339375751465609840801484592889925172867105767663865003474673877306782492180067353856493873352082672833242368295700361941406607094298524971010582848155295175876416280789802070376313832361148791530700602039387918303750966965311391574707837728570176384970704855124594407172251268098706978376090542912929344492513384183231040016207412648019561891411057151352984928184115181483534959666911309714744265773932487092170761893895469807486999330039447615795396834925983574737750806569360090695009597077440117397176004125384806886783639660621550162794222825503301866755919064102371025428970202609474167093725973377029019369542489008907399816344268271107251422642444394295031677496626574918192538987307032199141725692286015261369012945174380684144484086524852886270717368426832490990772158458075266904766542991903970407465284703623099975166486775916952691073355877964592340230731529088307662462168730966089062336436389277513929792989509527961806655782453847736236387259057358913693838332016851781407524359352813229072505380650711693049176679191021591021389372641247384964875287336650708846120446276882272810745622693709331578317206645848042706067557480758511553310824640020649394355322305550804086562784060919544289531008318716584762468479626254129440271062831239695632816441075920969278753806765451632278698182308325313693381046301850639648800754286747096420253430423489479466804681482044272737999450499555465823164480037422222367329404142745283822947899313540404366082279717101515216147594766392292429511243594117952923319141560834706050302935730124475680758933436231491685270482951411606790235850929380027076481544634203449136248177171198738003486838372217932769689898884784243826855286091288358239337707121625402050851090825870703676300673135330647766969648618275025084598123309185991065848687389917566591933063673989563554382295252021136544002390268843474613430643976640252484632736275857290476774458675146529714463940660919706163233969511685041545624837717646981487338708223589261847530514133271116906741091917303278220653192405195999010112864383206483703165777476499412818478890639921457227974733696980927826881905040085772367856544559431242332068267736163848514181227641896012840513431718789320462329400102516689122316306450427759800832003864806238880726778463445628851437837462460535312158694258263309302240517780411649608046974426356882853543894970861987774349994574781336617336532821610244134603281437218963727001383319023603953398010028490193243704729281796345148350290421966348930850029874490245386530847693496493617805444480239004190850309960252932678216332242871877009997232445612436261407704091991812835292853218055207198699990193596327522065871513324383404436885617489886675946278629169614212976734843602198938090909080423822416990482891694415707626880182335127385564845496968722502531064508236794490149037021373756875425278069621745860863912399196641388414399463171257761192133719058891540419926061937259684055960761838199081600923840918336924120526335236516500115108241855287430263809480233364084000105646409638910878994420820422552248809062853062971314598633808334114010418924133364933998209352785219452456089337721022144079478199256501302345218342858278235244199769192326879823000937772497828914123378185067698603690831733524939588396025784744225418501083799649691393873269892335315415985069239360869306287430161725433942167215211261881754762154607113521244775811112287675881463204557903372983296624502192459971356246676084633217778109344434581417296897250881570580436981350693342923679859228288541131389540894299576663507525370715066110292813780358628483132303131742983176445700582642966318721896316623598268218673189722517718549132701529540520838922283977941956346618584749724827265852568855500361230814706488134611068845316354598799199730845206624628172917488457386459633185969341459672532379007964850480186110477536989316248137632870890622881765455399233258931339410494872048786445380805620853716965362789859403153144908183575383939310217279705139721560019568071214255994974408572648841828625948484183872232281767754936910627565103682925375742419024815987856586166378115801243175559269046804610268271061187624472308223805466602642940260042682812756256714586960165383407898099487002894444062178839391272002262993374941547876859908138330758067507911277955632733866611899695647351688393078353839611712871637384462404921878353336617815170011477929312619557000783485114417555469412886951873941491122663330089140640237525839190435611147175201365580352057169422983019756479705286311737745688878300295162035783336721495176173005235943366036579342403031858371914608154767616552994518813852963325330926988565056420401996182426971074864830358200261362270644352471067742908740066312532706251619727693803689605359722994531913085746256816708333207607372464782479204187957800323115042281681129259667352353517828344865153265302260116463924808962369896134974192415072584064052318417051648079212739917316031264326241507504548923934897411859282836187869534528811502263549599774513219264816628970416773822011462914052436110107140947441642811202817152783793620844688755256396789417685977459433814911438287855016776285922198699082347185992693560300125534315526770599208589855117129892234808497648798749646357191091546146105862763759843591202631705539149848234511495065117372464217143148171544816412125072538951795020039403886647971400954941112844849901590156966236341935249533139330401618307950786879596469984119359421473188358955907773883294422386655263220117627516995224969119904423765978663514224958566699689223512229385859291888846405683717180332460248187496572144703276206259527743572333980326718238070708650626983118629971542697495485252436024567421318695854715454101364076644687730899594195633275321940815295981062932643316855398782785214003121345721054960499469768201901436790482699005065113381322434770359397558788285726356480844311358408385253074776523383477020175018046561198787369898157059096899613482593561519419424142071652533171543891165116251895092189352681035517633166882961672980048326420273966474172389658068362117989909317156664012999905834065753973024952538940459359134550258647169854000824881036941617642608336413135147747841565829503975928572807411306180458140011310004983383026486015252188390643855363612216856777424655584758055581172316113883725410980557553123430983725023598059269514271705141359723255705532679522179269076133226643135890378252461618715340762528062563692617084267038794880235151507089462270896512581989114649911930878095396167316626567923044257435256806444296060636631937672317042925789128926010875180848009703217786800815516725253240060242786574356358801695111745961187387934689215227487920216703113061886444488110070984015605138767865701169972101412815405111287993463590619141283476936740880771219789950164205754467253452729863863950188739206664510955140236732140158021974750113109733958553067094099406873014624519007182600409029981781192576220342072442404407525694905182026252480724976436388060662190514332680872481044874701969108472815273272711817597987293115253454183720993206057768497928765003643915107639254922781596562385649150660525460064354624202531015121109364122338886448890343464196409635269404582149158284742251021906623863213747664602076214326636400706220794772134432273627481233425177349936452817255847706031575002057972719912748242114947097609007914285108694438842246267149271162583225184547641087826552789896176698128504268589381137327318145707839809327397245651593444250042725815049799745201372918555659842435159140214766015206264721726961406530774240071612440812084893955728905341340722978959370951469131953687044216423231488696742678073353379700564119257217803190999447776766945656573316206535726981650249163828677908520393197985243387213795555465230391800618144495416908755212757986378350464035578468435976351162791656892497974733578066603931101486067508297960437234016531761812630581332141184120753306673976159208563797007731706257116416221162110419311205495221132895418746168121064205944498701002545540456478596919625174145565742316551390140063146675199648332585331762709727331999408582325796339606878970603814755703167837480442251068230531926699205980639895012239254327439300220930923024855090117769633765709714826339834535876565538006788679271916019685164920493416004883901394115173882206447090610228518660081719399539376075038070034810020211340293423040766585888292494537662913458772049817318437606250938129574541767841602448300145138073940696983979059415445451195212528787305894819950526282403144596367019708209116488019479785136064985877899731579692549619154770180888669752809069235496303872000398374241532650796235196695916947874428693058258893424293987791471045924421366356810359849529988292704148275922733760964828717638828532352066259757744446229184986951298617242419115550392412022848989840586920941416655818223507527601871564570641408192234786458318407574121105566577710381048872914691225665311980882110415222436817149605338657757168302854397900614706332327212921851066498300381053609841762266343669520372320628210114413639485761915162414609422533174459519006397814257737889054381038101112761472099883783780140565576787975042564664143611845913471061951575941338844337411203552878275342039192198521263603180368307831236175304268307887495444496370405314855591523212253");
        //int result = Result.substrings("21474836471");
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();


        // 597988838 actual
        // 719147630;
        // 199968383
        //bufferedReader.close();
        //bufferedWriter.close();
    }
}

