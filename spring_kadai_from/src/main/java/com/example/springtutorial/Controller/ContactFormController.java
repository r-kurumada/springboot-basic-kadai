package com.example.springtutorial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springtutorial.form.ContactForm;

@Controller
public class ContactFormController {

    // 入力画面を表示
    @GetMapping("/form")
    public String showForm(Model model) {
        // リダイレクト後に model にデータが残ってなければ新しく作る
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "confirmView"; // 入力フォーム
    }

    // 送信処理
    @PostMapping("/confirm")
    public String submitForm(
            @Validated ContactForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (result.hasErrors()) {
            // 入力値とエラー情報をフラッシュ属性に保存
            redirectAttributes.addFlashAttribute("contactForm", form);
            redirectAttributes.addFlashAttribute(
                    BindingResult.MODEL_KEY_PREFIX + "contactForm", result);

            // リダイレクトで元のフォームに戻る
            return "redirect:/form";
        }

        // エラーがなければ完了画面へ
        model.addAttribute("contactForm", form);
        return "contactFormView"; // 完了画面
    }
}
