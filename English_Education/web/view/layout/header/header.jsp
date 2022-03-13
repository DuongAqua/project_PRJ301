<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Header -->
    <header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">
      
      <div class="container-fluid">
        <div class="d-flex align-items-center">
            <div class="site-logo mr-auto w-25"><a href="index.jsp">OneSchool</a></div>

          <div class="mx-auto text-center">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mx-auto d-none d-lg-block  m-0 p-0">
                <li><a href="home" class="nav-link">Home</a></li>
                <li><a href="course" class="nav-link">Courses</a></li>
                <li><a href="#teachers-section" class="nav-link">Teachers</a></li>
                <c:if test="${sessionScope.user.type == 1}">
                <li><a href="#teachers-section" class="nav-link">manager</a></li>
                </c:if>
                
              </ul>
            </nav>
          </div>

          <div class="ml-auto w-25">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu main-menu site-menu-dark js-clone-nav mr-auto d-none d-lg-block m-0 p-0">
                <c:if test="${sessionScope.user == null}">
                      <li class="cta"><a href="login" class="nav-link"><span>Login</span></a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                      <li class="cta"><a href="logout" class="nav-link"><span>Log Out</span></a></li>
                </c:if>
                
              </ul>
            </nav>
            <a href="#" class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black float-right"><span class="icon-menu h3"> sadasdas</span></a>
          </div>
        </div>
      </div>
      
    </header>
<!-- Header  -->
