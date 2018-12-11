package th.ac.kmitl.a59070085;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    EditText _user, _pwd;
    String _userStr, _pwdStr;

    SQLiteDatabase db;
    Cursor cursor;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //open to use DataBase and create it.
        db = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user (user VARCHAR(20), name VARCHAR(50), age INT, password VARCHAR(200))");

        sharedPreferences = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        Boolean check = sharedPreferences.getBoolean("login", false);
        if(check){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_view, new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        }

        initLoginBtn();
        initRegisBtn();
    }

    public void initLoginBtn(){
        Button _loginBtn = getView().findViewById(R.id.login_login_btn);
        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _user = getView().findViewById(R.id.login_user);
                _userStr = _user.getText().toString();
                _pwd  = getView().findViewById(R.id.login_pwd);
                _pwdStr = _pwdStr.getText().toString();

                if(_userStr.isEmpty() && _pwdStr.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill out this form", Toast.LENGTH_SHORT).show();
                } else {
                    chkUser();
                }
            }
        });
    }

    void initRegisBtn(){
        TextView _regisBtn = getView().findViewById(R.id.login_resis_btn);
        _regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
//                            .replace(R.id.main_view, new ImgViewFragment())
//                            .replace(R.id.main_view, new FavoriteFragment())
                        .replace(R.id.main_view, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
                Log.d("LOGIN", "GOTO REGISTER");
            }
        });
    }

    void chkUser(){
        cursor = db.rawQuery("SELECT * FROM user", null);

        while (cursor.moveToNext()){
            String user = cursor.getString(0);
            String name = cursor.getString(1);
            String password = cursor.getString(3);
        }


}
