package com.example.springtutorial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springtutorial.form.ContactForm;

@Controller
public class ContactFormController {

	// 入力画面の表示
    @GetMapping("/form")
    public String showForm(ContactForm form) {
        return "confirmView"; 
    }

    // 送信処理
    @PostMapping("/form")
    public String submitForm(
            @Validated ContactForm form,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // バリデーションエラーがあれば、入力画面に戻す
            return "confirmView";
        }

        // エラーがなければ完了画面へ
        model.addAttribute("contactForm", form);
        return "contactFormView"; 
    }
}
