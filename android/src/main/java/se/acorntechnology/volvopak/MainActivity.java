package se.acorntechnology.volvopak;

import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private CounterStore counterStore = new CounterStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final TextView counterTextView = (TextView) findViewById(R.id.whatToDo);
        final Button counterButton = (Button) findViewById(R.id.counterButton);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        counterButton.setOnClickListener((view) -> {
            counterTextView.setText(counterStore.get());
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
