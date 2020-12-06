
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 

<%@ include file="../core/sideBar.jsp" %>
   <div id="layoutSidenav_content">
                <main>
  <div class="container-fluid">
                       <h2>Diseases </h2>
                        <div class="card mb-4">
                            <div class="card-body">
                            <!-- Content -->
     
      <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                               Diseases
                            </div>
<div class="card-body">
                                <div class="table-responsive">
	 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Details</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                               <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Details</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                        <c:forEach items="${diseases}" var="disease">
                                            <tr>
                                                <td>${disease.id}</td>
                                                <td>${disease.name}</td>
                                                <td>${disease.description}</td>
                                                 <td>
										<form method="get" 
									action="${pageContext.request.contextPath}/disasesSymptoms/addSymptom/${disease.id}">
								
								<button type="submit"  class="edit" title="details" data-toggle="tooltip">details</button>
								</form>
								</td>
                                                <td>
										<form method="get" 
									action="${pageContext.request.contextPath}/Diseases/edit/${disease.id}">
								
								<button type="submit"  class="edit" title="Edit" data-toggle="tooltip">	edit</button>
								</form>
								</td>
								 
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Diseases/delete/${disease.id}">
								 
									<button type="submit" title="Delete" class="edit" data-toggle="tooltip">delete</button>
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