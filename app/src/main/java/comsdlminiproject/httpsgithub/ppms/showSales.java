package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showSales extends AppCompatActivity
{
    TextView tvSales, tvSales2, tvEarn, tvEarn2, etTotalEarned;
    Button btnTallyWithBank;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sales);

        setupUIViews();
        //(TextView) tvSales = (TextView) findViewById(R.id.tvSales);
        tvSales.setText(getIntent().getStringExtra("SALES1") + "\t L");
        tvSales2.setText(getIntent().getStringExtra("SALES2") + "\t L");
        tvEarn.setText("Rs." + getIntent().getStringExtra("EARN1"));
        tvEarn2.setText("Rs." + getIntent().getStringExtra("EARN2"));

        double earn1= Double.parseDouble(getIntent().getStringExtra("EARN1"));
        double earn2= Double.parseDouble(getIntent().getStringExtra("EARN2"));

        final double totalSumForTally= (earn1+earn2);

        etTotalEarned.setText("Rs." + Double.toString(totalSumForTally));


        final String petrolprice=getIntent().getStringExtra("PETROLPRICE");
        final String petrolsold=getIntent().getStringExtra("PETROLSOLD");
        final String dieselprice=getIntent().getStringExtra("DIESELPRICE");
        final String dieselsold=getIntent().getStringExtra("DIESELSOLD");
        final String earnPetrol = getIntent().getStringExtra("EARN1");
        final String earnDiesel = getIntent().getStringExtra("EARN2");
        final String earnTotal = getIntent().getStringExtra("EARNTOTAL");


        btnTallyWithBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityAccounts.class);
                intent.putExtra("TotalSumForTally",Double.toString(totalSumForTally) );
                intent.putExtra("PETROLSOLD", petrolsold);
                intent.putExtra("PETROLPRICE", petrolprice);
                intent.putExtra("DIESELSOLD", dieselsold);
                intent.putExtra("DIESELPRICE", dieselprice);
                intent.putExtra("PETROLEARN", earnPetrol);
                intent.putExtra("DIESELEARN",earnDiesel);
                intent.putExtra("TOTALEARN", earnTotal);
                //intent.putExtra("EARNTOTAL", earnTotalText);

                startActivity(intent);
            }
        });





    }

    public void setupUIViews()
    {
        tvSales = findViewById(R.id.tvSales);
        tvSales2 = findViewById(R.id.tvSales2);
        tvEarn = findViewById(R.id.tvEarn);
        tvEarn2 = findViewById(R.id.tvEarn2);
        etTotalEarned = findViewById(R.id.etTotalEarned);
        btnTallyWithBank= findViewById(R.id.btnTallyWithBank);
    }
}
