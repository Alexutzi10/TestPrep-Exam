package com.example.examtest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.examtest.data.Exam;
import com.example.examtest.network.AsyncTaskRunner;
import com.example.examtest.network.Callback;
import com.example.examtest.network.ExamParser;
import com.example.examtest.network.HttpManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private EditText et;
    private Spinner spinner;
    private TextView tv;
    private Button bttn;
    private static final String api = "https://api.npoint.io/5b2a9af3a9e1874bdc4d";
    private AsyncTaskRunner asyncTaskRunner= new AsyncTaskRunner();
    private List<Exam> exams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();

        fab.setOnClickListener(click -> {
            Callable<String> httpManager = new HttpManager(api);
            Callback<String> httpManagerCallback = onMainThreadOperation();
            asyncTaskRunner.executeAsync(httpManager, httpManagerCallback);
        });
    }

    private Callback<String> onMainThreadOperation() {
        return result -> {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            List<Exam> parsedExams = ExamParser.extractFromJSON(result);
            exams.addAll(parsedExams);
            Log.i("Exams", exams.toString());
        };
    }

    private void initComponents() {
        fab = findViewById(R.id.surugiu_george_alexandru_fab);
        et = findViewById(R.id.surugiu_george_alexandru_et);
        spinner = findViewById(R.id.surugiu_george_alexandru_spinner);
        tv = findViewById(R.id.surugiu_george_alexandru_tv);
        bttn = findViewById(R.id.surugiu_george_alexandru_bttn);
    }
}