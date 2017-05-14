package com.shc.SHC_SS.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import com.shc.SHC_SS.R;
import com.shc.SHC_SS.utilies.HCApplication;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class AgreementActivity extends AppCompatActivity {

    HtmlTextView textView;
    Button mNextButton;
    String introductionHtmlText = "<p dir=\"rtl\"><span style=\"font-size: large;\"><strong style=\"font-size: large;\"> &nbsp;المقدمة:</strong></span></p>\n" +
            "<p dir=\"rtl\"><strong>عزيزي المشارك / عزيزتي المشاركة:</strong></p>\n" +
            "<p dir=\"rtl\"><strong><br /> تم اختيار المشاركين في هذه الدراسة من مختلف مناطق المملكة العربية السعودية باستخدام طريقة علمية، بهدف إجراء المقابلة الشخصية باستخدام استبيان أعده المجلس الصحي السعودي وفقا للمنهجية التي وضعتها منظمة الصحة العالمية لقياس استجابة النظام الصحي وطبقتها في مختلف دول العالم.<br /> يقوم بإجراء المقابلات الشخصية متخصصون تم استقطابهم من عدة جهات لجمع بيانات الدراسة.<br /> المعلومات التي تقدمها لنا ستستخدم لقياس العوامل المؤثرة على استجابة النظام الصحي في المملكة.</strong></p>\n" +
            "<p dir=\"rtl\"><strong>سوف تستغرق المقابلة 60 دقيقة تقريبا. وسوف نسألك عن:</strong></p>\n" +
            "<ul dir=\"rtl\">\n" +
            "<li dir=\"RTL\"><strong>بعض البيانات الشخصية.</strong></li>\n" +
            "<li dir=\"RTL\"><strong>صحتك بما يتضمن ذلك أي مشاكل صحية تعرضت لها والعلاج الذي قد تكون تلقيته.</strong></li>\n" +
            "<li dir=\"RTL\"><strong>الخدمات الصحية التي استخدمتها وكيف كانت الاستجابة مقابل احتياجك لها.</strong></li>\n" +
            "<li><strong>المعلومات التي تزودنا بها ستكون محاطة بالسرية التامة، وسيتم استخدامها لأغراض البحث العلمي وتطوير الخدمات الصحية فقط، وبدون الإشارة إلى أسماء المشاركين ومعلوماتهم الشخصية.</strong></li>\n" +
            "</ul>\n" +
            "<p dir=\"rtl\"><strong>فريق الدراسة المسحية قد يقوم بالتواصل معك مره أخرى فقط إن كان هناك ضرورة لإكمال بعض بيانات الاستبيان.</strong></p>\n" +
            "<p dir=\"rtl\"><strong>مشاركتك في الاستبيان اختيارية وتستطيع الانسحاب من الاستبيان حتى بعد موافقتك على لذلك ولديك الحرية لترفض الإجابة عن أي من الأسئلة. وإذا كانت لديك أية استفسارات تستطيع سؤالي او التواصل مع منشأتنا على هذا الايميل (</strong><span style=\"color: #0000ff;\"><strong>aq.alotaibi@chs.gov.sa</strong></span><strong>)</strong></p>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HCApplication.newInstance().preventLocalization();
        setContentView(R.layout.activity_agreement);
        initViews();
        Typeface typeFace = Typeface.createFromAsset(HCApplication.context.getAssets(), HCApplication.context.getString(R.string.font_name));
        // if (isTablet(context)) {

        HCApplication.saveDataInSharedPrefrances.save_data_int("ActivityMove","activity_value",2);
        textView.setTypeface(typeFace, Typeface.BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        textView.setHtml(introductionHtmlText);
        textView.setTextColor(getResources().getColor(R.color.question_color));
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgreementActivity.this, Section0991.class));
            }
        });
    }

    private void initViews() {
        textView = (HtmlTextView) findViewById(R.id.tv_introduction);
        mNextButton = (Button) findViewById(R.id.btn_next);
    }

    @Override
    protected void onPause() {
        super.onPause();
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "selectjson", HCApplication.all_item.toString());
        HCApplication.saveDataInSharedPrefrances.save_data_String("Allitem", "question", HCApplication.all_selected.toString());
    }
}
