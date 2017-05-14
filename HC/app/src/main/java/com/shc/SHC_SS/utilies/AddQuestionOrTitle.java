package com.shc.SHC_SS.utilies;

/**
 * Created by jawdah on 4/5/2017.
 */

public class AddQuestionOrTitle {

    public void addQuestion(String q_name_json, String r_name_json) throws Exception {
        HCApplication.question.add(HCApplication.readQuestionFromJsonFile.getStringFromJson(q_name_json));
        HCApplication.question_name.add(q_name_json);
        HCApplication.check.add("");
        HCApplication.move_ment.add("e".trim());
        HCApplication.stringArrayList.add(HCApplication.readQuestionFromJsonFile.getArrayFromJson(r_name_json).toString());
    }

    public void addTitle(String check_value, String title_value) {
        HCApplication.question.add(check_value);
        HCApplication.check.add("");
        HCApplication.question_name.add(title_value);
        HCApplication.stringArrayList.add("");
        HCApplication.move_ment.add("a");

    }

    public void addQuestionValue(String q_name_json, String r_name_json) throws Exception {
        HCApplication.question.add(q_name_json);
        HCApplication.question_name.add(q_name_json);
        HCApplication.check.add("");
        HCApplication.stringArrayList.add(HCApplication.readQuestionFromJsonFile.getArrayFromJson(r_name_json).toString());

    }

    public void addQuestionValue(String q_name_json, String q_name_value, String r_name_json) throws Exception {
        HCApplication.question.add(q_name_json);
        HCApplication.question_name.add(q_name_value);
        HCApplication.check.add("");
        HCApplication.move_ment.add("e".trim());
        HCApplication.stringArrayList.add(HCApplication.readQuestionFromJsonFile.getArrayFromJson(r_name_json).toString());

    }

    public void addQuestionValueSpinner(String q_name_json, String r_name_json) throws Exception {
        HCApplication.question.add(HCApplication.readQuestionFromJsonFile.getStringFromJson(q_name_json));
        HCApplication.question_name.add(q_name_json);
        HCApplication.check.add("");
        HCApplication.move_ment.add("e".trim());
        HCApplication.stringArrayList.add(r_name_json.toString());

    }
}
