package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"front-end/About/nicepage.css\" media=\"screen\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"front-end/About/Home.css\" media=\"screen\">\r\n");
      out.write("    <script class=\"u-script\" type=\"text/javascript\" src=\"front-end/About/jquery.js\" defer=\"\"></script>\r\n");
      out.write("    <script class=\"u-script\" type=\"text/javascript\" src=\"front-end/About/nicepage.js\" defer=\"\"></script>\r\n");
      out.write("    <meta name=\"generator\" content=\"Nicepage 4.12.5, nicepage.com\">\r\n");
      out.write("    <link id=\"u-theme-google-font\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i\">\r\n");
      out.write("    <link id=\"u-page-google-font\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Advent+Pro:100,200,300,400,500,600,700|Cambay:400,400i,700,700i\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script type=\"application/ld+json\">{\r\n");
      out.write("      \"@context\": \"http://schema.org\",\r\n");
      out.write("      \"@type\": \"Organization\",\r\n");
      out.write("      \"name\": \"\",\r\n");
      out.write("      \"logo\": \"images/hehe.png\",\r\n");
      out.write("      \"sameAs\": []\r\n");
      out.write("      }</script>\r\n");
      out.write("    <meta name=\"theme-color\" content=\"#478ac9\">\r\n");
      out.write("    <meta property=\"og:title\" content=\"Home\">\r\n");
      out.write("    <meta property=\"og:type\" content=\"website\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body data-home-page=\"Home.html\" data-home-page-title=\"Home\" class=\"u-body u-xl-mode\">\r\n");
      out.write("    <header class=\"u-align-center-sm u-align-center-xs u-clearfix u-header u-sticky u-sticky-5514 u-header\" id=\"sec-04e9\" style=\"background-color: #2C31CF;height: 80px;display: flex;align-items: center;\"><div class=\"u-clearfix u-sheet u-sheet-1\">\r\n");
      out.write("        <a href=\"#\" class=\"u-image u-logo u-image-1\"  >\r\n");
      out.write("            <img src=\"images/logowhite-removebg-preview.png\" class=\"u-logo-image u-logo-image-1\">\r\n");
      out.write("        </a>\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"u-align-right u-menu u-menu-dropdown u-offcanvas u-menu-1\">\r\n");
      out.write("          <div class=\"menu-collapse\" style=\"font-size: 1rem;\">\r\n");
      out.write("            <a class=\"u-button-style u-nav-link\" href=\"#\">\r\n");
      out.write("              <svg class=\"u-svg-link\" preserveAspectRatio=\"xMidYMin slice\" viewBox=\"0 0 302 302\" style=\"color: #EEE;margin-right: 10px\"><use xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:href=\"#svg-8a8f\"></use></svg>\r\n");
      out.write("              <svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" id=\"svg-8a8f\" x=\"0px\" y=\"0px\" viewBox=\"0 0 302 302\" style=\"enable-background:new 0 0 302 302;\" xml:space=\"preserve\" class=\"u-svg-content\"><g><rect y=\"36\" width=\"302\" height=\"30\"></rect><rect y=\"236\" width=\"302\" height=\"30\"></rect><rect y=\"136\" width=\"302\" height=\"30\"></rect>\r\n");
      out.write("              </g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>\r\n");
      out.write("            </a>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"u-custom-menu u-nav-container\" style=\"color: #EEE\">\r\n");
      out.write("            <div class=\"right-nav\">\r\n");
      out.write("              <ul class=\"u-nav u-unstyled u-nav-1\">\r\n");
      out.write("                <li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base\" href=\"home.jsp\" style=\"padding: 10px 20px;\">View Student</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base\" href=\"#\" style=\"padding: 10px 20px;\">View Course</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base\" href=\"#\" style=\"padding: 10px 20px;\">View Author</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                \r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"u-custom-menu u-nav-container-collapse\">\r\n");
      out.write("            <div class=\"u-align-center u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav\">\r\n");
      out.write("              <div class=\"u-inner-container-layout u-sidenav-overflow\">\r\n");
      out.write("                <div class=\"u-menu-close\"></div>\r\n");
      out.write("                <ul class=\"u-align-left u-nav u-popupmenu-items u-unstyled u-nav-2\">\r\n");
      out.write("                  <li class=\"u-nav-item\">\r\n");
      out.write("\r\n");
      out.write("                    <a class=\"u-button-style u-nav-link\" href=\"home.jsp\">\r\n");
      out.write("                      Home\r\n");
      out.write("                    </a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link\" href=\"#\">View Student</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link\" href=\"#\">View Course</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link\" href=\"#\">View Author</a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"u-black u-menu-overlay u-opacity u-opacity-70\"></div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("      </div>\r\n");
      out.write("      <style class=\"u-sticky-style\" data-style-id=\"5514\">\r\n");
      out.write("        .u-sticky-fixed.u-sticky-5514, .u-body.u-sticky-fixed .u-sticky-5514 {\r\n");
      out.write("            box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important\r\n");
      out.write("        }\r\n");
      out.write("        .u-sticky-fixed.u-sticky-5514:before, .u-body.u-sticky-fixed .u-sticky-5514:before {\r\n");
      out.write("            borders: top right bottom left !important;\r\n");
      out.write("            border-color: #404040 !important;\r\n");
      out.write("            border-width: 2px !important\r\n");
      out.write("        }</style>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
