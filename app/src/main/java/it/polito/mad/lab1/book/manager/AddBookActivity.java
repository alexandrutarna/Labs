package it.polito.mad.lab1.book.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import it.polito.mad.lab1.R;

public class AddBookActivity extends AppCompatActivity
        implements View.OnClickListener {

    // Variable for the search input field
    private EditText mIsbnInput;

    // Variables for results TextViews.
    private TextView mTitleText;
    private TextView mAuthorText;
    private TextView mbookISBN;
    private TextView mbookPublisher;
    private TextView mbookEditionYear;
    private TextView mextraDeails;




    /**
     * Standard Activity lifecycle methods
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        // take the reference to input field for ISBN
        mIsbnInput = (EditText)findViewById(R.id.isbn_input);

        // take the referrence for TextViews containing the info about the book
        mTitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);
        mAuthorText = (TextView)findViewById(R.id.isbnText);
        mAuthorText = (TextView)findViewById(R.id.publisherText);
        mAuthorText = (TextView)findViewById(R.id.editionYearText);
        mAuthorText = (TextView)findViewById(R.id.extraDetailsText);

        // take the reference for the search Button
        findViewById(R.id.searchBookButton).setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchBookButton:
                searchBooks();
                break;
        }

    }


    /**
     * Gets called when the user pushes the "Search Books" button
     */
    public void searchBooks() {
        // Get the search string from the input field.
        String queryString = mIsbnInput.getText().toString();

        // Hide the keyboard when the button is pushed.
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If the network is active and the search field is not empty, start a FetchBook AsyncTask.
        if (networkInfo != null && networkInfo.isConnected() && queryString.length()!=0) {
//            new FetchBook(mTitleText, mAuthorText, mBookInput).execute(queryString);

            Book myBook = new Book();

            new FetchBookByIsbn(mTitleText, mAuthorText, mIsbnInput).execute(queryString);


        }
        // Otherwise update the TextView to tell the user there is no connection or no search term.
        else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText(R.string.no_search_term);
            } else {
                mAuthorText.setText("");
                mTitleText.setText(R.string.no_network);
            }
        }
    }

}
