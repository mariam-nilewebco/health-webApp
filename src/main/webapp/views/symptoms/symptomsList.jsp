
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 

<%@ include file="../core/sideBar.jsp" %>
   <div id="layoutSidenav_content">
                <main>
  <div class="container-fluid">
                       <h2>Symptoms </h2>
                        <div class="card mb-4">
                            <div class="card-body">
                            <!-- Content -->
     
      <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                               Symptoms
                            </div>
<div class="card-body">
                                <div class="table-responsive">
	 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                               <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                        <c:forEach items="${symptoms}" var="symptom">
                                            <tr>
                                                <td>${symptom.id}</td>
                                                <td>${symptom.name}</td>
                                                <td>${symptom.description}</td>
                                                <td>
										<form method="get" 
									action="${pageContext.request.contextPath}/Symptoms/edit/${symptom.id}">
								
								<button type="submit"  class="edit" title="Edit" data-toggle="tooltip">
								edit</button>
								</form>
								</td>
								 
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Symptoms/delete/${symptom.id}">
								 
									<button type="submit" value="Delete" class="btn small" >delete</button>
								</form> 
							</td>
                                            </tr>
                                           
                                            </c:forEach>
                                        </tbody>
                                    </table>
                             </div>
							 </div>
							 </div>
							 <!--  End COntent -->
							 
							 </div>
                        </div>
                    </div>
                </main>
               
                
<%@ include file="../core/footer.jsp" %>