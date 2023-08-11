<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
      <title>Juego Ninja Gold</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link rel="stylesheet" type="text/css" href="css/styleindex.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    </head>

    <body>
      <div class="container mt-5 text-center justify-content-center">
        <div class="d-flex justify-content-center">
          <p>Your Gold: <span class="border border-2 px-3 border-dark">
              <c:choose>
                <c:when test="${empty gold}">0</c:when>
                <c:otherwise>${gold}</c:otherwise>
              </c:choose>
            </span></p>
        </div>

        <form action="/activities" method="POST">
          <div class="d-flex justify-content-center row m-5">
            <div class="col-sm-2">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Farm</h5>
                  <p class="card-text p-3">(earns 10 - 20 gold)</p>
                  <button type="submit" name="place" value="farm" class="btn btn-primary btn-dark">Find Gold!</button>
                </div>
              </div>
            </div>
            <div class="col-sm-2">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Cave</h5>
                  <p class="card-text p-3">(earns 5 - 10 gold)</p>
                  <button type="submit" name="place" value="cave" class="btn btn-primary btn-dark">Find Gold!</button>
                </div>
              </div>
            </div>
            <div class="col-sm-2">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">House</h5>
                  <p class="card-text p-3">(earns 2 - 5 gold)</p>
                  <button type="submit" name="place" value="house" class="btn btn-primary btn-dark">Find Gold!</button>
                </div>
              </div>
            </div>
            <div class="col-sm-2">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Casino!</h5>
                  <p class="card-text p-3">(earns/takes 0-50 gold)</p>
                  <button type="submit" name="place" value="casino" class="btn btn-primary btn-dark">Find Gold!</button>
                </div>
              </div>
            </div>
            <div class="col-sm-2">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Spa</h5>
                  <p class="card-text p-3">(takes 5 - 20 gold)</p>
                  <button type="submit" name="place" value="spa" class="btn btn-primary btn-dark">Find Gold!</button>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>

      <footer class="mt-5 text-center">
        <div class="row">
          <h3>Activities:</h3>
        </div>
        <div class="row">
          <div class="scrollable-list overflow-y">
            <ul>
              <c:forEach var="activity" items="${activities}">
                <li>
                  <c:choose>
                    <c:when test="${activity.gold > 0}">
                      <span style="color: green">You entered a ${activity.place} and earned ${activity.gold} gold.
                        (${activity.getFormattedTime()})</span>
                    </c:when>
                    <c:otherwise>
                      <span style="color: red">You entered a ${activity.place} and lost ${activity.gold} gold.
                        (${activity.getFormattedTime()})</span>
                    </c:otherwise>
                  </c:choose>
                </li>
              </c:forEach>
            </ul>
          </div>
        </div>
        <div class="row">
          <form action="/reset" method="post">
            <a href="javascript:void(0);" onclick="resetCounter();"><button type="submit">Reset</button></a>
          </form>
        </div>

        <script>
          function resetCounter() {
            document.getElementById("resetForm").submit();
          }
        </script>

      </footer>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
        crossorigin="anonymous"></script>
    </body>

    </html>