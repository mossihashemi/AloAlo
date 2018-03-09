package co.example.um2.aigle.alo.Common.Welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import co.example.um2.aigle.alo.R;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = (TextView) findViewById(R.id.textview);
        String message;

        /* Bundle extras permet de récupérer les données envoyées par une autre activité via les putString vérifier MainActivity.login()*/
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            message = null;
        }else{
            message = "Welcome " + extras.getString("nom") + " " + extras.getString("prenom")
                    + " \n Your email is : " + extras.getString("mail");
        }
        textView.setText(message);
    }
}
