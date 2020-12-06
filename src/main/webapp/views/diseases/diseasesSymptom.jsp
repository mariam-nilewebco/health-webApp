 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 

<%@ include file="../core/sideBar.jsp" %>
   <div id="layoutSidenav_content">
                <main>
  <div class="container-fluid">
                       <h2>Disease List </h2>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                            
<form:form action="${pageContext.request.contextPath}/disasesSymptoms/navigate/${disease.id}"
			id="form1"	method="post"  modelAttribute="disease" enctype="multipart/form-data">
				 
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="id">ID : </label>
						<form:input type="text" path="id" id="id"
							class="form-control trans" placeholder="ID"  readOnly='true'/>
					</div>
				<div class="form-group col-md-6">

					 </div>
				</div>

				<div class="form-row">
				<div class="form-group col-md-6">

						<label for="name">Name : </label>

						<form:input type="text" path="name" placeholder="Name"
							id="name" class="form-control trans" readOnly='true' style=""/>
					</div>
					<div class="form-group col-md-6">
						<label for="description">Description : </label>
						<form:input type="description" path="description" id="description" readOnly='true' 
							class="form-control trans" placeholder="Description" />
					</div>
				</div>
				 
			</form:form>
			<hr><hr>
			<form:form action="${pageContext.request.contextPath}/disasesSymptoms/${disease.id}/addSymptom"
				method="post" modelAttribute="lookup" enctype="multipart/form-data">
							 
				<div class="form-row">
					 
				<div class="form-group col-12">

						<label for="id">Symtpoms : </label>
						<form:select path="id">
							<form:options itemValue="id" itemLabel="name" items="${items}" />

						</form:select>
					</div>
				</div>
 
				<div class="form-row">
				<div class="form-group col-md-12">
			  <small>${errorMsg}</small>
				 <button type="submit" class="btn btn-primary" >Add</button> 
				</div> 
				</div>
				</form:form>
</div>
                        </div>
                    
                    <!-- Disease Symptoms List -->
                       <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                <h3>${disease.name} Symptom</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                     <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th> 
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                               <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                 
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                        <c:forEach items="${disease.symptoms}" var="symptom">
                                            <tr>
                                                <td>${symptom.id}</td>
                                                <td>${symptom.name}</td>
                                                <td>${symptom.description}</td>
                                               
							 
                                            </tr>
                                           
                                            </c:forEach>
                                        </tbody>
                                    </table>
       
                                </div>
                            </div>
                        </div>
                    <!-- End Disease Symptoms List -->
                    </div>
                </main>
               
                
<%@ include file="../core/footer.jsp" %>