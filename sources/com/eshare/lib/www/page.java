package com.eshare.lib.www;

/* renamed from: com.eshare.lib.j.b */
/* loaded from: classes.dex */
public class page {
    /* renamed from: a */
    public static void generate(StringBuilder sb, String title, StringBuilder content, boolean enableUploadForm, boolean chineseMode, boolean iphonecompat) {
        String str;
        String str2;
        sb.append("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"stylesheet\" type=\"text/css\" href=\"/remote/mobile.css\"/><script src=\"/remote/jquery.js\" type=\"text/javascript\"></script><script src=\"/remote/mobile.js\" type=\"text/javascript\"></script><title>");
        sb.append(title);
        if (enableUploadForm) {
            sb.append("</title><link href=\"/remote/fineuploader-3.4.1.css\" rel=\"stylesheet\"><link rel=\"shortcut icon\" href=\"/remote/favicon.ico\" mce_href=\"/remote/favicon.ico\" type=\"image/x-icon\"><style type=\"text/css\">body{margin:0; height:100% }html{ height:100% }");
            if (!iphonecompat) {
                sb.append(".left{ width:250px; height:100%; float:right; _margin-right:-3px; margin-top:20px;}.main{height:100%;margin-right:260px;}");
            }
            sb.append("</style></head><body><div data-role=\"page\"><div data-role=\"content\"><div id=\"left\" class='left'><div id=\"fileuploader\"></div><div style='margin-top:10px;background-color:#FF9797;text-align:center;text-shadow:none;padding:8px 0;'>");
            sb.append(chineseMode ? "上传完成后，请手动刷新浏览器" : "After the upload is complete, manually refresh your browser");
            str = "</div></div><div id=\"main\" class='main'><ul data-role=\"listview\" data-split-icon=\"delete\" data-inset=\"true\" >";
        } else {
            str = "</title><link href=\"/remote/fineuploader-3.4.1.css\" rel=\"stylesheet\"><link rel=\"shortcut icon\" href=\"/remote/favicon.ico\" mce_href=\"/remote/favicon.ico\" type=\"image/x-icon\"></head><body><div data-role=\"page\"><div data-role=\"content\"><ul data-role=\"listview\" data-inset=\"true\" data-split-icon=\"delete\" >";
        }
        sb.append(str);
        sb.append((CharSequence) content);
        if (enableUploadForm) {
            sb.append("</ul></div></div><script src=\"/remote/fineuploader-3.4.1.js\"></script><script src=\"/remote/iframe.xss.response-3.4.1.js\"></script><script>function createUploader() {var h = $(window).height();var w = $(window).width();var uploader = new qq.FineUploader({element: document.getElementById('fileuploader'), text: {uploadButton: '<div>");
            sb.append(chineseMode ? "上传文件" : "Upload Files");
            str2 = "</div>'},request: {endpoint: '?action=mutiupload'}});if(w<599){$('#left').removeClass('left');$('#main').removeClass('main');}}window.onload = createUploader;</script></div></body></html>";
        } else {
            str2 = "</ul></div><script src=\"/remote/fineuploader-3.4.1.js\"></script><script src=\"/remote/iframe.xss.response-3.4.1.js\"></script></div></body></html>";
        }
        sb.append(str2);
    }
}
