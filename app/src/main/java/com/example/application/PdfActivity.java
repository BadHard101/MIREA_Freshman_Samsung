package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        PDFView pdfView = findViewById(R.id.pdfview);

        pdfView.fromAsset("Shpora.pdf").load();
    }
}