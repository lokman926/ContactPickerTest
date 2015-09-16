package hk.com.takers.contactpickertest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class contactpickertest extends AppCompatActivity {
    public static final int PICK_CONTACT    = 1;
    private Button btnContacts;
    private TextView txtContacts1;
    private TextView                txtContacts2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactpickertest);
        btnContacts = (Button) findViewById(R.id.btn_contacts);
        txtContacts1 = (TextView) findViewById(R.id.txt_contacts_name);
        txtContacts2 = (TextView) findViewById(R.id.txt_contacts_number);
        btnContacts.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK, People.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
            }
        });
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        switch (reqCode) {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();

                    //srart


                    //end

                    Cursor c = getContentResolver().query(contactData, null, null, null, null);
                    while(c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                        String phoneno =
                                c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        //showtoast(phoneno);
                        //txtContacts1.setText(phoneno);
                    }

                    /*

                    Cursor c = getContentResolver().query(contactData, null, null, null, null);
                    while(c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                        String phoneno =
                                c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        //showtoast(phoneno);
                        //txtContacts1.setText(phoneno);
                    }
                    */

                }
                break;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contactpickertest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
