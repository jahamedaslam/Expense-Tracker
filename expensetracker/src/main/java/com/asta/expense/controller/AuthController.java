package com.asta.expense.controller;

import com.asta.expense.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    private static final String LOGIN = "admin/login";
    private static final String ARTICLE_ADD_PAGE = "admin/add-article";
    private static final String ARTICLE_LIST_PAGE = "admin/list-article";
    private static final String ARTICLES_EDIT_PAGE = "admin/edit-article";
    private static final String ARCHIVE_LIST_PAGE = "admin/archive-list";

//    @Autowired
//    @Qualifier("ArticleMapper")
//    ArticleMapper articleMapper;
//    @Autowired
//    AppUserService articleService;
//
//
//    @GetMapping("/")
//    public String getLogin(){
//        return LOGIN;
//    }
//
//    @GetMapping("/list")
//    public String article(ModelMap model) {
//        List<Article> articles = articleService.listAllArticles();
//        List<ArticleForm> articleForms = articleMapper.listArticleForm(articles);
//        model.addAttribute("articles", articleForms);
//        return ARTICLE_LIST_PAGE;
//    }
//
//    @GetMapping("/archive-list")
//    public String archivedList(ModelMap model) {
//        logger.info("Open Archived List page");
//        List<Article> articles = articleService.archivedArticles();
//        List<ArticleForm> articleForms = articleMapper.listArticleForm(articles);
//        model.addAttribute("articles", articleForms);
//        return ARCHIVE_LIST_PAGE;
//    }
//
//    @GetMapping("/add")
//    public String showAddPage(Model model) {
//        logger.info("Open article add form");
//        ArticleForm articleForm = new ArticleForm();
//        model.addAttribute("articleForm", articleForm);
//        return ARTICLE_ADD_PAGE;
//    }
//
//    @PostMapping("/post")
//    public String showAddPage(@ModelAttribute("articleForm") ArticleForm articleForm, @RequestPart("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
//        logger.info("save Article");
//        Article article = articleMapper.map(articleForm , file);
//        logger.info(String.valueOf(file.getBytes()));
//        articleService.saveArticle(article);
//        redirectAttributes.addFlashAttribute("savedSuccess", true);
//        return "redirect:/article/list";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editArticle(Model model, @PathVariable Long id) throws NumberFormatException, NotFoundException {
//        logger.info("Open article edit form");
//        Article article = articleService.getArticleById(id);
//        ArticleForm articleForm = articleMapper.remap(article);
//        model.addAttribute("articleForm", articleForm);
//        return ARTICLES_EDIT_PAGE;
//    }
//
//    @PostMapping("/update")
//    public String updateArticle(@ModelAttribute("articleForm") ArticleForm articleForm, @RequestPart("file") MultipartFile file, RedirectAttributes redirectAttributes) throws NotFoundException, IOException {
//        logger.info("update article");
//        Article getArticle = articleService.getArticleById(Long.valueOf(articleForm.getId()));
//        Article updateArticle = articleMapper.map(articleForm,getArticle,file);
//        articleService.updateArticle(updateArticle);
//        redirectAttributes.addFlashAttribute("savedSuccess", true);
//        return "redirect:/article/list";
//    }
//
//    @PostMapping(value = "/{id}/delete")
//    @ResponseBody
//    public Map<String, Boolean> deleteArticle(@PathVariable String id) throws NotFoundException {
//        Map<String, Boolean> map = new HashMap<String, Boolean>();
//        Article article = articleService.deleteArticle(Long.valueOf(id));
//        if (article == null) {
//            map.put("Success", Boolean.FALSE);
//        }
//        map.put("Success", Boolean.TRUE);
//        return map;
//    }
//
//    @PostMapping(value = "/{id}/publish")
//    @ResponseBody
//    public Map<String, Boolean> publishArticle(@PathVariable String id) throws NotFoundException {
//        Map<String, Boolean> map = new HashMap<String, Boolean>();
//        Article article = articleService.publishArticle(Long.valueOf(id));
//        if (article == null) {
//            map.put("Success", Boolean.FALSE);
//        }
//        map.put("Success", Boolean.TRUE);
//        return map;
//    }
//
//    @PostMapping(value = "/{id}/archive")
//    @ResponseBody
//    public Map<String, Boolean> archiveArticle(@PathVariable String id) throws NotFoundException {
//        Map<String, Boolean> map = new HashMap<String, Boolean>();
//        Article article = articleService.archiveArticle(Long.valueOf(id));
//        if (article == null) {
//            map.put("Success", Boolean.FALSE);
//        }
//        map.put("Success", Boolean.TRUE);
//        return map;
//    }
}
