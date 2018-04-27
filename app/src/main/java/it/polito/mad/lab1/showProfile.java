package it.polito.mad.lab1;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import it.polito.mad.lab1.book.manager.AddBookActivity;


public class showProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);

// TODO: 25-Apr-18 start
        final Button signInButton = findViewById(R.id.btn_sign_in_from_show_profile);
        signInButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("btn pressed \n");
                signIn();
            }

        });

        // TODO: 25-Apr-18 end

        // TODO: 27-Apr-18  start button for add book
        final Button addBookButton = findViewById(R.id.btn_add_book_from_show_profile);
        addBookButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("btn pressed \n");
                addBook();
            }

        });


        // TODO: 27-Apr-18 end

    }


    @Override
    protected void onResume() {
        super.onResume();

        System.out.print("HELLO!\n\n");

        SharedPreferences sharedPref = this.getSharedPreferences("shared_id", Context.MODE_PRIVATE);

        String name = sharedPref.getString("name", null);
        String mail = sharedPref.getString("mail", null);
        String bio = sharedPref.getString("bio", null);
        String photoPath = sharedPref.getString("photo", null);


        TextView show_name = findViewById(R.id.name);
        TextView show_email = findViewById(R.id.mail);
        TextView show_bio = findViewById(R.id.bio);

        show_name.setText(name);
        show_email.setText(mail);
        show_bio.setText(bio);

        Bitmap bitmap = null;

        //System.out.print("prima dell'if!\n\n");




        if (photoPath != null) {
            try {
                System.out.print("try!\n\n");

                Uri saved_uri = saved_uri = Uri.parse(photoPath);
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), saved_uri);
                final ImageView img = findViewById(R.id.img);
                img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.print("catch!\n\n");

            }
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.show_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.editButton:
                editProfile();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void editProfile(){
        Intent intent = new Intent(getApplicationContext(), editProfile.class);
        startActivity(intent);
    }



    // TODO: 25-Apr-18 intent for startng SignInActivity
    public void signIn(){
        Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(intent);
    }
    // TODO: 25-Apr-18 end


    // TODO: 27-Apr-18 intent for starting addBook

    public void addBook(){
        Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
        startActivity(intent);
    }
    // TODO: 27-Apr-18 end intent



}
