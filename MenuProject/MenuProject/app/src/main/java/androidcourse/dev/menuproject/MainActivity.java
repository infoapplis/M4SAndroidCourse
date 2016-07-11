package androidcourse.dev.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void AfficheSMS(View v) {

        final Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode("771759341")));
        intent.putExtra("sms_body","Bonjour El Hadji Lamine Biaye");
        startActivity(intent);
    }

    public void AfficheTel(View v) {

        final Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:771759341"));
        startActivity(intent);
    }

    public void AfficheWeb(View v) {

        final Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
        websiteIntent.setData(Uri.parse("http://www.google.sn"));
        startActivity(websiteIntent);
    }

    public void AfficheCarte(View v) {

        //final Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW);
        //mapIntent.setData(Uri.parse("12.807428, -16.234371"));
        //final Intent chooser=Intent.createChooser(mapIntent, "Lancement de la carte");
        //startActivity(chooser);

        //String geoUri = String.format("12.807428, -16.234371");
        //Uri geo = Uri.parse(geoUri);
        //Intent geoMap = new Intent(android.content.Intent.ACTION_VIEW, geo);
        //startActivity(geoMap);

        Uri gmmIntentUri = Uri.parse("geo:12.807428, -16.234371");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void AffichePartager(View v) {

       // final Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setAction(Intent.ACTION_SEND);
        //intent.setType("text/plain");
        //intent.putExtra(Intent.EXTRA_SUBJECT, "Facebook");
        //intent.putExtra(Intent.EXTRA_TEXT, "Partager avec vos amis");
        //startActivity(Intent.createChooser(intent,"Share the love"));

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT,"Partager avec vos amis");
        Intent.createChooser(sendIntent,"Share the love");
        startActivity(sendIntent);
    }

    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Partager");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Ici nous apprenons comment partager des informations avec des amis ");
        startActivity(Intent.createChooser(sharingIntent, "Share The love"));
    }

    public void AfficheNewActivity(View v) {

        Intent intent = new Intent(MainActivity.this, NewActivity.class);
        startActivity(intent);
    }

    public void AfficheAide(View v) {

        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);
    }

    public void shareIntent() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("Text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Heloo from mobilemerit");
        startActivity(Intent.createChooser(shareIntent, "Share"));
    }





}
