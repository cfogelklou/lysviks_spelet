package se.acorntechnology.volvopak;

import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class MainActivity extends Activity {
    private Random mRand = new Random();
    private final String CHARADER = "Charader!";
    private final String[] STRINGS = {
            CHARADER,
            CHARADER,
            "Tumme mäster",
            "Sjung",
            "Rimma",
            "Rimma",
            "Regel",
            "Saga",
            "Saga",
            "Ämne",
            "Ämne",
    };

    ArrayList<String> mAssignments = new ArrayList<>();

    private TextView mCounterTextView;
    private String mCounterText = "ingen än";
    private Thread mThread;
    private String mCharadeText = "ingen än";
    private Button mCharadeButton;


    public String get() {

        if (mAssignments.size() <= 0){
            for (int i = 0; i < STRINGS.length;i++){
                mAssignments.add(STRINGS[i]);
            }
        }
        int  n = mRand.nextInt(mAssignments.size());
        String assignment = mAssignments.get(n);
        mAssignments.remove(n);
        if (assignment.equals(CHARADER)){
            mCharadeText = getCharade();
        }
        else {
            mCharadeText = "";
        }
        return assignment;
    }

    private final String[] CHARADES = {
            "Spela fotboll",
            "Basket",
            "Hockey",
            "giraff äter löv",
            "lejon",
            "katt leker med garn",
            "elefant rädd för en mus",
            "ko",
            "mus",
            "gorilla",
            "häst",
            "kanin",
            "apa",
            "hund",
            "fisk",
            "haj",
            "ambulance",
            "Sparka tegelstenar",
            "Solglasögon",
            "Mygga",
            "Sax",
            "Klippa gräss",
            "Klippa häcken",
            "Stjärna",
            "Rymdskepp",
            "Träd",
            "Flygplan",
            "Svans",
            "Basketboll",
            "Toalett",
            "Telefon",
            "Burk",
            "Trumma",
            "Spela gitarr",
            "Spela triangel",
            "Sköldpadda",
            "vingar",
            "Docka",
            "Fågel",
            "Spindel",
            "Barn",
            "Gris",
            "Krita",
            "Ärm",
            "Kanin",
            "Kamera",
            "Sten",
            "Kyckling",
            "Robot",
            "Dryck",
            "Ballong",
            "Känguru",
            "Tandborste",
            "Dörr",
            "Alligator",
            "Dansa",
            "Hoppa",
            "Mygga",
            "Polis",
            "Nypa"
    };

    public String getCharade() {
        int  n = mRand.nextInt(CHARADES.length);
        return CHARADES[n];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mCounterTextView = (TextView) findViewById(R.id.whatToDo);
        final Button counterButton = (Button) findViewById(R.id.counterButton);
        mCharadeButton = (Button)findViewById(R.id.charadeButton);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mRand.setSeed(System.nanoTime());

        counterButton.setOnClickListener((view) -> {
            mCounterText = get();
            mCounterTextView.setText(Html.fromHtml(mCounterText));
        });

        mCharadeButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mCharadeText = getCharade();
                return false;
            }
        });
        mCharadeButton.setOnClickListener((view) -> {
            mCounterText = mCharadeText;//getCharade();
            mCounterTextView.setText(Html.fromHtml(mCounterText));
            mThread = new Thread() {
                @Override
                public void run() {
                    for (int i = 5; (mCharadeText.length() > 0) && (this == mThread) && (i > 0); i--) {
                        final int cnt = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mCounterTextView.setText(Html.fromHtml(mCounterText + " " + Integer.toString(cnt)));
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ((mCharadeText.length() > 0)) {
                                mCounterTextView.setText("");
                            }
                        }
                    });
                }
            };
            mThread.start();
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
