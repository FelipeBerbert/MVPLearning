package br.felipeberbert.mvplearning.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import br.felipeberbert.mvplearning.R;
import br.felipeberbert.mvplearning.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText firstName;
    private EditText lastName;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        firstName = (EditText) findViewById(R.id.fistName);
        lastName = (EditText) findViewById(R.id.lastName);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error: the user is not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Error: First or last name cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String fname) {
        firstName.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        lastName.setText(lname);
    }


}
