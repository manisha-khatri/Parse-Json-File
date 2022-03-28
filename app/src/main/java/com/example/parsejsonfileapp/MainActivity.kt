package com.example.parsejsonfileapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //way 1
        val jsonFileString = getJsonDataFromAsset(this, "typeahead.json")
        val gson = Gson()
        val post: TypeAhead = gson.fromJson(jsonFileString, TypeAhead::class.java)
        Log.d("data", post.navigationModules?.size.toString())

        //way 2
        val post1: TypeAhead = gson.fromJson(typeAhead_json, TypeAhead::class.java)
        Log.d("data", post1.navigationModules?.size.toString())
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    val typeAhead_json = "{\n" +
            "  \"navigationModules\":\n" +
            "  [\n" +
            "    {\n" +
            "      \"type\": \"facet\",\n" +
            "      \"displayName\": \"Screen size\",\n" +
            "      \"facetName\": \"screen_size\",\n" +
            "      \"values\": [\n" +
            "        {\n" +
            "          \"displayName\": \"Large\",\n" +
            "          \"url\": \"http://walmart.com\",\n" +
            "          \"image\": \"http://walmart.com\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"displayName\": \"Small\",\n" +
            "          \"url\": \"http://walmart.com\",\n" +
            "          \"image\": \"http://walmart.com\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"facet\",\n" +
            "      \"displayName\": \"Color\",\n" +
            "      \"facetName\": \"color\",\n" +
            "      \"values\": [\n" +
            "        {\n" +
            "          \"displayName\": \"Blue\",\n" +
            "          \"url\": \"http://walmart.com\",\n" +
            "          \"image\": \"http://walmart.com\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"displayName\": \"Red\",\n" +
            "          \"url\": \"http://walmart.com\",\n" +
            "          \"image\": \"http://walmart.com\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"queries\": [\n" +
            "    {\n" +
            "      \"type\": \"QUERY\",\n" +
            "      \"displayName\": \"nintendo switch\",\n" +
            "      \"url\": \"query=nintendo%20switch&typeahead=nintendo\",\n" +
            "      \"metaData\": {\n" +
            "        \"deptId\": \"0\",\n" +
            "        \"deptName\": \"All Departments\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"QUERY\",\n" +
            "      \"displayName\": \"nintendo switch\",\n" +
            "      \"url\": \"query=nintendo%20switch&typeahead=nintendo\",\n" +
            "      \"metaData\": {\n" +
            "        \"deptId\": \"2636\",\n" +
            "        \"deptName\": \"Video Games\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"QUERY\",\n" +
            "      \"displayName\": \"nintendo switch games\",\n" +
            "      \"url\": \"query=nintendo%20switch%20games&typeahead=nintendo\",\n" +
            "      \"metaData\": {\n" +
            "        \"deptId\": \"0\",\n" +
            "        \"deptName\": \"All Departments\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}"



}