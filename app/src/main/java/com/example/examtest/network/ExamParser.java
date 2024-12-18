package com.example.examtest.network;

import android.util.Log;

import com.example.examtest.data.Course;
import com.example.examtest.data.DateConverter;
import com.example.examtest.data.Exam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamParser {
    public static List<Exam> extractFromJSON(String json) {
        List<Exam> exams = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(json);
            JSONArray array = root.getJSONArray("values");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                JSONObject data = object.getJSONObject("data");

                String dateStr = data.getString("date");
                String coursestr = data.getString("course");
                String classroom = data.getString("classroom");
                String supervisor = data.getString("supervisor");

                Date date = DateConverter.toDate(dateStr);
                Course course = Course.valueOf(coursestr);

                Exam exam = new Exam(date, course, classroom, supervisor);
                exams.add(exam);
            }
            return exams;
        } catch (JSONException e) {
            Log.e("ParseException", "Error when parsing the given JSON.");
        }
        return new ArrayList<>();
    }
}
