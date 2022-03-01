package pl.mk_it.sms;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText value;
    String month;
    final int SEND_SMS_PERMISSION_REQUEST = 1;

    String Debrzno = "608069501\n" +
            "501615860\n" +
            "503333751\n" +
            "505534875\n" +
            "509125692\n" +
            "512537549\n" +
            "514417370\n" +
            "515759973\n" +
            "606381352\n" +
            "609492648\n" +
            "661791180\n" +
            "664727364\n" +
            "669142463\n" +
            "669142463\n" +
            "669976523\n" +
            "692908250\n" +
            "692924863\n" +
            "697452240\n" +
            "721468458\n" +
            "723073459\n" +
            "723483015\n" +
            "730634488\n" +
            "781031938\n" +
            "783790866\n" +
            "785558554\n" +
            "503629976\n" +
            "504871978\n" +
            "506391872\n" +
            "601712550\n" +
            "602805641\n" +
            "604689715\n" +
            "604706444\n" +
            "606832579\n" +
            "664755160\n" +
            "665110668\n" +
            "690691756\n" +
            "691816453\n" +
            "691816453\n" +
            "691968714\n" +
            "696423537\n" +
            "721163006\n" +
            "783585569\n" +
            "784307284\n" +
            "785327626\n" +
            "785978083\n" +
            "886370224\n" +
            "886658067\n" +
            "504554303\n" +
            "572637212\n" +
            "575096404\n" +
            "602654453\n" +
            "662266496\n" +
            "665074519\n" +
            "665093853\n" +
            "669405024\n" +
            "669962080\n" +
            "692974784\n" +
            "695392996\n" +
            "695877578\n" +
            "721141736\n" +
            "725062120\n" +
            "783147456\n" +
            "786284810\n" +
            "787929905\n" +
            "788075289\n" +
            "790257813\n" +
            "505037767\n" +
            "505534875\n" +
            "507115228\n" +
            "508941733\n" +
            "510265779\n" +
            "511682661\n" +
            "534301418\n" +
            "573345257\n" +
            "603119399\n" +
            "609467008\n" +
            "661391369\n" +
            "663657939\n" +
            "664567110\n" +
            "665742102\n" +
            "669426987\n" +
            "692866822\n" +
            "693730107\n" +
            "695831201\n" +
            "724041977\n" +
            "724203246\n" +
            "735953377\n" +
            "781702141\n" +
            "883352158\n" +
            "884975930\n" +
            "501615860\n" +
            "508326559\n" +
            "511966983\n" +
            "531762209\n" +
            "572141643\n" +
            "576618941\n" +
            "663613657\n" +
            "664755160\n" +
            "665049405\n" +
            "665994210\n" +
            "667289864\n" +
            "669405024\n" +
            "669962080\n" +
            "695092269\n" +
            "723073459\n" +
            "724203246\n" +
            "725203954\n" +
            "727615677\n" +
            "787929905\n" +
            "792425732\n" +
            "886702953\n" +
            "888051116\n";

    String [] DebrznoNumbers = Debrzno.split("\n");
//    String [] DebrznoNumbers = Debrzno.split(", *");

    String Wierzchowo ="507899398\n" +
            "663125868\n" +
            "665741067\n" +
            "668013280\n" +
            "724811262\n" +
            "783800486\n" +
            "788136755\n" +
            "508089478\n" +
            "516216025\n" +
            "663125868\n" +
            "663752466\n" +
            "785194451\n" +
            "786100848\n" +
            "788176660\n" +
            "794622511\n" +
            "886691919\n" +
            "888098516\n" +
            "698432198\n" +
            "606231486\n" +
            "515842922\n" +
            "600625116\n" +
            "698373927\n" +
            "533116040\n" +
            "533649912\n" +
            "572533637\n" +
            "662014426\n" +
            "668408187\n" +
            "694992567\n" +
            "794622511\n" +
            "609421449\n";
//    String [] WierzchowoNumbers = Wierzchowo.split(", *");
    String [] WierzchowoNumbers = Wierzchowo.split("\n");

    String Rychonowy ="605872512\n" +
            "534552501\n" +
            "668678113\n" +
            "669726826\n" +
            "735853859\n" +
            "790244991\n" +
            "791965521\n" +
            "889194793\n" +
            "534552501\n" +
            "665578903\n" +
            "698756115\n" +
            "726385924\n" +
            "732845649\n" +
            "781069586\n" +
            "782716032\n" +
            "785214686\n" +
            "796610609\n" +
            "881941597\n" +
            "692657446\n" +
            "723812620\n" +
            "724276514\n" +
            "884221104\n" +
            "608728004\n" +
            "783494313\n" +
            "888725209\n" +
            "788905024\n" +
            "792059050\n" +
            "721295271\n" +
            "886346912\n" +
            "531224742\n" +
            "504951062\n" +
            "519182767\n" +
            "881950933\n" +
            "508301423\n" +
            "530447788\n" +
            "601460130\n" +
            "606383020\n" +
            "607369566\n" +
            "607958897\n" +
            "661719249\n" +
            "662037325\n" +
            "669284548\n" +
            "691773982\n" +
            "735853859\n" +
            "781954751\n" +
            "781954751\n" +
            "783679959\n" +
            "884221104\n" +
            "791965521\n";

//    String [] RychnowyNumbers = Rychonowy.split(", *");
    String [] RychnowyNumbers = Rychonowy.split("\n");

    String JacekAgatka = "502043655\n" +
            "502216921\n" +
            "503576266\n" +
            "505750701\n" +
            "505750701\n" +
            "506354505\n" +
            "506434854\n" +
            "507145946\n" +
            "509441995\n" +
            "602680151\n" +
            "609285432\n" +
            "667014586\n" +
            "667714037\n" +
            "669162566\n" +
            "692476428\n" +
            "696655737\n" +
            "730214144\n" +
            "782027264\n" +
            "792466767\n" +
            "792589765\n" +
            "794527605\n" +
            "888430462\n" +
            "500168619\n" +
            "501099576\n" +
            "511120050\n" +
            "518107673\n" +
            "600764600\n" +
            "600813015\n" +
            "601964734\n" +
            "666865489\n" +
            "668814974\n" +
            "696986672\n" +
            "790516582\n" +
            "790769487\n" +
            "889989603\n" +
            "501178595\n" +
            "505357485\n" +
            "506354505\n" +
            "509570760\n" +
            "530232122\n" +
            "530666699\n" +
            "572363919\n" +
            "602320625\n" +
            "604244638\n" +
            "606583380\n" +
            "609802877\n" +
            "660795574\n" +
            "665068082\n" +
            "666063335\n" +
            "697501901\n" +
            "721034049\n" +
            "723414029\n" +
            "723726815\n" +
            "790463900\n" +
            "880712233\n" +
            "885415109\n" +
            "606763455\n" +
            "880583090\n" +
            "792262562\n" +
            "505789094\n" +
            "517727849\n" +
            "537195889\n" +
            "601250831\n" +
            "605355377\n" +
            "605378716\n" +
            "609799136\n" +
            "660793908\n" +
            "666257981\n" +
            "668425845\n" +
            "669574534\n" +
            "696959548\n" +
            "697501901\n" +
            "721013248\n" +
            "723402482\n" +
            "723544091\n" +
            "723636985\n" +
            "724147066\n" +
            "792171359\n" +
            "884811718\n" +
            "885415109\n" +
            "503718884\n" +
            "508394090\n" +
            "577512342\n" +
            "602739884\n" +
            "608557762\n" +
            "609883486\n" +
            "661313290\n" +
            "669257254\n" +
            "669877395\n" +
            "669877395\n" +
            "669952116\n" +
            "669957283\n" +
            "724670898\n" +
            "781660975\n" +
            "798750422\n" +
            "880714714\n" +
            "884811718\n" +
            "884811718\n" +
            "888856071\n" +
            "500378284\n" +
            "505750701\n" +
            "509940057\n" +
            "512346412\n" +
            "516164186\n" +
            "530232122\n" +
            "535093487\n" +
            "574856811\n" +
            "600608841\n" +
            "604244638\n" +
            "606583380\n" +
            "606763455\n" +
            "608296949\n" +
            "608299539\n" +
            "661186007\n" +
            "663657954\n" +
            "665231298\n" +
            "669257254\n" +
            "695247080\n" +
            "721034049\n" +
            "781792164\n" +
            "784334716\n" +
            "886434074\n" +
            "888135135\n";

    String [] JacekAgatkaNumbers = JacekAgatka.split("\n");

    String Bajka = "501744747\n" +
            "502346142\n" +
            "505039579\n" +
            "601866393\n" +
            "603707328\n" +
            "607446564\n" +
            "609376665\n" +
            "665170113\n" +
            "667959897\n" +
            "683988084\n" +
            "692233671\n" +
            "733243492\n" +
            "782021921\n" +
            "785649057\n" +
            "785649057\n" +
            "797256585\n" +
            "514913891\n" +
            "537722468\n" +
            "609356009\n" +
            "695897141\n" +
            "697307199\n" +
            "790619008\n" +
            "790812905\n" +
            "792292561\n" +
            "798674584\n";

//    String [] BajkaNumbers = Bajka.split(", *");
    String [] BajkaNumbers = Bajka.split("\n");

    String Piano = "505829890\n" +
            "601631018\n" +
            "603366655\n" +
            "606502136\n" +
            "607868215\n" +
            "609415872\n" +
            "665218329\n" +
            "669728945\n" +
            "695109166\n" +
            "721013021\n" +
            "736622269\n" +
            "781939949\n" +
            "783238494\n" +
            "783238494\n" +
            "788927663\n" +
            "791110966\n" +
            "880547929\n" +
            "883911513\n" +
            "505829890\n" +
            "535957016\n" +
            "577145500\n" +
            "606384733\n" +
            "694453017\n" +
            "695792143\n" +
            "730996097\n" +
            "880099400\n" +
            "886381696\n" +
            "889135429\n" +
            "889719386\n" +
            "505012629\n" +
            "508274515\n" +
            "509901315\n" +
            "510130537\n" +
            "535880144\n" +
            "603366544\n" +
            "603401552\n" +
            "663756421\n" +
            "783238494\n" +
            "783682523\n" +
            "785540872\n" +
            "790239702\n" +
            "792559749\n" +
            "795510447\n" +
            "882101028\n" +
            "888523634\n" +
            "793162037\n" +
            "504934912\n" +
            "505327732\n" +
            "505851766\n" +
            "509606174\n" +
            "537270290\n" +
            "609722118\n" +
            "694188794\n" +
            "726108621\n" +
            "792559749\n" +
            "536311505\n";

    String [] PianoNumbers = Piano.split("\n");

    String Polnica = "539264855\n" +
            "691859796\n" +
            "508001215\n" +
            "604215090\n" +
            "607439579\n" +
            "660645967\n" +
            "667793817\n" +
            "691915592\n" +
            "724036736\n" +
            "725080418\n" +
            "726385414\n" +
            "781598841\n" +
            "660645967\n" +
            "667567914\n" +
            "667793817\n" +
            "695121424\n" +
            "722034261\n" +
            "788909131\n" +
            "796155178\n" +
            "888800372\n" +
            "538106239\n" +
            "601684690\n" +
            "667184928\n" +
            "667793817\n" +
            "725080418\n" +
            "730951015\n" +
            "790648748\n" +
            "884958471\n";
    String [] PolnicaNumbers = Polnica.split("\n");

    String Przechlewo  = "694255579\n" +
            "516077963\n" +
            "530300945\n" +
            "570391510\n" +
            "607457591\n" +
            "608670903\n" +
            "665588307\n" +
            "667532458\n" +
            "728316582\n" +
            "784067923\n" +
            "880544695\n" +
            "886213577\n" +
            "888131947\n" +
            "888741906\n" +
            "506069450\n" +
            "530300945\n" +
            "539336287\n" +
            "575183670\n" +
            "577475604\n" +
            "604460394\n" +
            "607528866\n" +
            "660007605\n" +
            "694824207\n" +
            "696712736\n" +
            "724664963\n" +
            "730660841\n" +
            "781786734\n" +
            "787909623\n" +
            "886418957\n" +
            "880941575\n" +
            "505909742\n" +
            "508301415\n" +
            "530632252\n" +
            "531069288\n" +
            "608670903\n" +
            "660391254\n" +
            "665588307\n" +
            "668861209\n" +
            "693448950\n" +
            "694308692\n" +
            "695855663\n" +
            "728581367\n" +
            "883390161\n" +
            "886252745\n" +
            "888131947\n" +
            "889087721\n" +
            "508301415\n" +
            "661226438\n" +
            "695239504\n" +
            "696074360\n" +
            "696788452\n" +
            "721468511\n" +
            "729671889\n" +
            "888483143\n" +
            "888909994\n" +
            "603245991\n";
    String [] PrzechlewoNumbers = Przechlewo.split("\n");

    String DebrznoZlobek = "516331070\n" +
            "690151527\n" +
            "724146031\n" +
            "509265254\n" +
            "534661797\n" +
            "536007017\n" +
            "574814097\n" +
            "607315934\n" +
            "609467160\n" +
            "663807146\n" +
            "665093853\n" +
            "782569158\n" +
            "799702889\n" +
            "880123223\n" +
            "882622882\n" +
            "886270596\n" +
            "886702953\n";
    String [] DebrznoZlobekNumbers = DebrznoZlobek.split("\n");





    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = findViewById(R.id.editValue);
        Button btnDebrzno = findViewById(R.id.btnDebrzno);
        Button btnJacekAgatka = findViewById(R.id.btnJacekAgatka);
        Button btnWierzchowo = findViewById(R.id.btnWierzchowo);
        Button btnPiano = findViewById(R.id.btnPiano);
        Button btnBajka = findViewById(R.id.btnBajka);
        Button btnRychnowy = findViewById(R.id.btnRychnowy);
        Button btnPolnica = findViewById(R.id.btnPolnica);
        Button btnPrzechlewo = findViewById(R.id.btnPrzechlewo);
        Button btnDebrznoZlobek = findViewById(R.id.btnDebrznoZlobek);

        Spinner spinnerMonth = findViewById(R.id.spinnerMonthList);
        ArrayAdapter<String> monthList = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.months));
        monthList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthList);
        spinnerMonth.setOnItemSelectedListener(this);

        //set buttons to false
        btnDebrzno.setEnabled(false);
        btnJacekAgatka.setEnabled(false);
        btnWierzchowo.setEnabled(false);
        btnPiano.setEnabled(false);
        btnBajka.setEnabled(false);
        btnRychnowy.setEnabled(false);
        btnPolnica.setEnabled(false);
        btnPrzechlewo.setEnabled(false);
        btnDebrznoZlobek.setEnabled(false);

        if (checkPermission(Manifest.permission.SEND_SMS)) {
            btnDebrzno.setEnabled(true);
            btnJacekAgatka.setEnabled(true);
            btnWierzchowo.setEnabled(true);
            btnPiano.setEnabled(true);
            btnBajka.setEnabled(true);
            btnRychnowy.setEnabled(true);
            btnPolnica.setEnabled(true);
            btnPrzechlewo.setEnabled(true);
            btnDebrznoZlobek.setEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        month = parent.getItemAtPosition(position).toString();
      }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }


//    @RequiresApi(api = Build.VERSION_CODES.R)
    public void smsSendDebrzno(View view) {
        String valueCount = value.getText().toString();

        String msgDebrzno = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu w Debrznie w miesiącu " + month +
                " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }

        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : DebrznoNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgDebrzno);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }



//
//    public void smsSendTest(View view) {
//        String valueCount = value.getText().toString();
//
//        String msgTest = "To tylko testowe wysyłanie wiadomości z aplikacji  - usuń je :) " + '\n' + '\n' +
//                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu w Debrznie w miesiącu " + month +
//                " br. wynosi: " + valueCount + " zł." + '\n' +
//                "Proszę o wpłatę na numer konta: 38 1240 3796 1111 0010 9768 0276." + '\n' +
//                "W tytule wpłaty proszę wpisać: nazwisko i imię/grupa/przedszkole" + '\n' +
//                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
//                "Marek Kołodziejski";
//
//        if (valueCount.length() == 0 || month.length() == 0) {
//            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
//        }
//
//        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
//        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
//        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
//                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
//        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
//                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
//        for (String phoneNumber : testPhones) {
//
////            System.out.println(phoneNumber);
//            try {
//                SmsManager sms = SmsManager.getDefault();
//                ArrayList<String> parts = sms.divideMessage(msgTest);
//                for (int i = 0; i < parts.size(); i++) {
//                    sentPendingIntents.add(i, sentPI);
//                    deliveredPendingIntents.add(i, deliveredPI);
//                }
//                sms.sendMultipartTextMessage(phoneNumber, null, parts,
//                        sentPendingIntents, deliveredPendingIntents);
//                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                Toast.makeText(this, "bląd" + e.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    public void smsSendWierzchowo(View view) {
        String valueCount = value.getText().toString();

        String msgWierzchowo = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu w Wierzchowie Człuchowskim " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : WierzchowoNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgWierzchowo);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void smsSendRychonowy(View view) {
        String valueCount = value.getText().toString();

        String msgRychnowy = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Rychnowach w miesiącu " + month +
                " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
//
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : RychnowyNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgRychnowy);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void smsSendJacekAgatka(View view) {
        String valueCount = value.getText().toString();

        String msgJacekAgatka = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu im. Jacka i Agatki w Człuchowie " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : JacekAgatkaNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgJacekAgatka);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void smsSendBajka(View view) {
        String valueCount = value.getText().toString();

        String msgBajka = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu Bajka w Człuchowie " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
//        @SuppressLint("UnspecifiedImmutableFlag")
//        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
//                new Intent(SENT_SMS_ACTION_NAME), 0);
//        @SuppressLint("UnspecifiedImmutableFlag")
//        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
//                new Intent(DELIVERED_SMS_ACTION_NAME), 0);
//
//        for (String phoneNumber : BajkaNumbers) {
//            try {
//                SmsManager sms = SmsManager.getDefault();
//                ArrayList<String> parts = sms.divideMessage(msgBajka);
//
//                ArrayList<PendingIntent> sendList = new ArrayList<>();
//                sendList.add(sentPI);
//
//                ArrayList<PendingIntent> deliverList = new ArrayList<>();
//                deliverList.add(deliveredPI);
//
//                sms.sendMultipartTextMessage(phoneNumber, null, parts, sendList, deliverList);
//                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
//                System.out.println(phoneNumber);
//                System.out.println(parts);
//
//            } catch (Exception e) {
//                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : BajkaNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgBajka);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void smsSendPiano(View view) {
        String valueCount = value.getText().toString();

        String msgPiano = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu Piano w Człuchowie " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : PianoNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgPiano);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void smsSendPolnica(View view) {
        String valueCount = value.getText().toString();

        String msgPiano = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu w Polnicy " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : PolnicaNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgPiano);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void smsSendPrzechlewo(View view) {
        String valueCount = value.getText().toString();

        String msgPiano = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Przedszkolu w Przechlewie " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : PrzechlewoNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgPiano);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void smsSendDebrznoZlobek(View view) {
        String valueCount = value.getText().toString();

        String msgPiano = "Witam :) " + '\n' +
                "Opłata za zajęcia Aktywnej Ziomkolandii w Żłobku w Debrznie " +
                "w miesiącu " + month + " br. wynosi: " + valueCount + " zł." + '\n' +
                "Zgodnie z regulaminem, proszę o pomniejszenie opłaty za zajęcia tylko w przypadku" +
                " gdy wysłali Państwo sms'a/maila w związku z nieobecnością dziecka. " + '\n' +
                "W razie jakichkolwiek wątpliwości co do formy i obowiązku płatności proszę o ponowne" +
                " zapoznanie się z regulaminem zajęć." + '\n' +
                "Nr konta do wpłaty: 38 1240 3796 1111 0010 9768 0276." + '\n' +
                "W tytule wpłaty: nazwisko i imię/grupa/przedszkole" + '\n' +
                "Proszę o terminowe uregulowanie płatności " + '\n' + "Pozdrawiam " + '\n' +
                "Marek Kołodziejski";

        if (valueCount.length() == 0 || month.length() == 0) {
            Toast.makeText(this, "Uzupełnij pola", Toast.LENGTH_SHORT).show();
        }
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<>();
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsSentReceiver.class), 0);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0,
                new Intent(getApplicationContext(), SmsDeliveredReceiver.class), 0);
        for (String phoneNumber : DebrznoZlobekNumbers) {
            try {
                SmsManager sms = SmsManager.getDefault();
                ArrayList<String> parts = sms.divideMessage(msgPiano);

                for (int i = 0; i < parts.size(); i++) {
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);
                }
                sms.sendMultipartTextMessage(phoneNumber, null, parts,
                        sentPendingIntents, deliveredPendingIntents);
                Toast.makeText(this, "Message send!", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}


