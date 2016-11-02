package org.apache.jsp.WEB_002dINF.content;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/bootstrap.min.css\"/>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<form  style=\"margin-left:auto;margin-right:auto;margin-top:auto;margin-bottom:auto\" action=\"result.action\">\n");
      out.write("    <input name=\"fromCity\" class=\"autocomplete\" id=\"fromCity\" required>\n");
      out.write("    <input name=\"toCity\" class=\"autocomplete\" id=\"toCity\" required>\n");
      out.write("    <input type=\"radio\" name=\"mode\" value=\"driving\" required>Driving\n");
      out.write("    <input type=\"radio\" name=\"mode\" value=\"walking\">Walking\n");
      out.write("    <input type=\"radio\" name=\"mode\" value=\"bicycling\">Bicycling\n");
      out.write("    <input type=\"radio\" name=\"mode\" value=\"transit\">Transit\n");
      out.write("    <input type=\"submit\" class=\"btn btn-success\">\n");
      out.write("</form>\n");
      out.write("<script>\n");
      out.write("    function initialize() {\n");
      out.write("        var input = document.getElementById('fromCity');\n");
      out.write("        var autocomplete = new google.maps.places.Autocomplete(input);\n");
      out.write("    }\n");
      out.write("    function anotherInitialize() {\n");
      out.write("        var input = document.getElementById('toCity');\n");
      out.write("        var autocomplete = new google.maps.places.Autocomplete(input);\n");
      out.write("    }\n");
      out.write("    google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("    google.maps.event.addDomListener(window, 'load', anotherInitialize);\n");
      out.write("</script>");
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
