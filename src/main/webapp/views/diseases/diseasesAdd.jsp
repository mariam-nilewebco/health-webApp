 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 

<%@ include file="../core/sideBar.jsp" %>
   <div id="layoutSidenav_content">
                <main>
  <div class="container-fluid">
                       <h2>Add Disease </h2>
                        <div class="card mb-4">
                            <div class="card-body">
                            
<form:form action="${pageContext.request.contextPath}/Diseases/save"
				method="post" modelAttribute="disease" enctype="multipart/form-data">
				 
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="id">ID</label>
						<form:input type="text" path="id" id="id"
							class="form-control" placeholder="ID"  readonly="${readonly}"/>
					</div>
				<div class="form-group col-md-6">

						 
					</div>
				</div>

				<div class="form-row">
				<div class="form-group col-md-6">

						<label for="name"> Name</label>

						<form:input type="text" path="name" placeholder="Name"
							id="name" class="form-control" readonly="${readonly}" />
					</div>
					<div class="form-group col-md-6">
						<label for="description">Description</label>
						<form:input type="description" path="description" id="description"
							class="form-control" placeholder="Description"  readonly="${readonly}" />
					</div>
					 

				</div>
				<br>
				<small class="text-danger">${errorMsg }</small>
				<br><br>
				<div class="form-row">
			  
				 	 	<button type="submit" class="btn btn-primary">Save</button>
				</div> 
			
			</form:form>
 
</div>
                        </div>
                    </div>
                </main>
               
                
<%@ include file="../core/footer.jsp" %>