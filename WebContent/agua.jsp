<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Health Track</title>

    <!-- Custom fonts for this template-->
    <link href="cssboot/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="cssboot/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion no-print" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Health Track</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="Index?cod=${CodId}">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>
                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Menu Principal
                </div>

                 <!-- Nav Item - Charts -->
                 <li class="nav-item">
                    <a class="nav-link" href="Peso?CodId=${CodId}">
                        <i class="fas fa-fw fa-weight"></i>
                        <span>Peso</span></a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="AtvidadeCtrl?CodId=${CodId}">
                        <i class="fas fa-fw fa-futbol"></i>
                        <span>Atividade física</span></a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="AlimentoCtrl?CodId=${CodId}">
                        <i class="fas fa-fw fa-utensils"></i>
                        <span>Alimentação</span></a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="AguaCtrl?CodId=${CodId}">
                        <i class="fas fa-fw fa-glass-whiskey"></i>
                        <span>Bebendo mais água</span></a>
                </li>
    
                <li class="nav-item">
                    <a class="nav-link" href="PressaoCtrl?CodId=${CodId}">
                        <i class="fas fa-fw fa-broadcast-tower"></i>
                        <span>Pressão arterial</span></a>
                </li>
    
                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">
    
                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
    
                <!-- Sidebar Message -->
    
    
            </ul>
            <!-- End of Sidebar -->
    
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
    
                <!-- Main Content -->
                <div id="content">
    
                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
    
                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
    
                        <!-- Topbar Search -->
                        <form
                            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="O que deseja pesquisar?"
                                    aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
    
                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
    
                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                    aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                placeholder="Search for..." aria-label="Search"
                                                aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>
    
                            <!-- Nav Item - Alerts -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">1+</span>
                                </a>
                                <!-- Dropdown - Alerts -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="alertsDropdown">
                                    <h6 class="dropdown-header">
                                        Novidades
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-success">
                                                <i class="fas fa-donate text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">29 de Outubro, 2021</div>
                                            Seja bem vindo ao Health Track!
                                        </div>
                                    </a>
    
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Mostrar todas</a>
                                </div>
                            </li>
    
                            <!-- Nav Item - Messages -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-envelope fa-fw"></i>
                                    <!-- Counter - Messages -->
                                  <!--  <span class="badge badge-danger badge-counter">7</span> -->
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="messagesDropdown">
                                    <h6 class="dropdown-header">
                                        Mensagens
                                    </h6>
    
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                                </div>
                            </li>
    
                            <div class="topbar-divider d-none d-sm-block"></div>
    
                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Nome Usuário</span>
                                    <img class="img-profile rounded-circle"
                                        src="cssboot/img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="DeletUsr?CodId=${CodId}">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Apagar Conta
                                    </a>
    
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Sair
                                    </a>
                                </div>
                            </li>
    
                        </ul>
    
                    </nav>
                    <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800 text-center">Controle de ingestão de Agua</h1>

                </div>
						<!-- DataTales Example -->
					<div class="row">
						<div class="col-lg-7">
							<div class="p-5">
								<div class="text-center">
									<p class="h4 text-gray-900 mb-4 text-left">Cadastrar Ingestão</p>
								</div>
								<form class="user" action="AguaCtrl?=${CodId}" method="post">
									
									<div class="form-group">
										<input type="text" class="form-control form-control-user" name=agua
											id="exampleFirstName" placeholder="Agua Observação">
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user" name=vlAgua
											id="exampleFirstName" placeholder="Volume de Agua em Litros (Apenas Numeros)">
									</div>
									<div class="form-group">
										<input type="date" class="form-control form-control-user" name=dateAgua
											id="exampleFirstName" placeholder="Data">
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user" name=qtdAgua
											id="exampleFirstName" placeholder="Quantidade de Copos (Apenas Números)">
									</div>
									
									<input type="hidden" name=CodId value="${CodId}">
										
									

									<div class="form-group row"></div>
									<button type="submit" class="btn btn-primary btn-user btn-block">
                                    Cadastar
                                	</button>

								</form>
							</div>
						</div>
					</div>

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Cadastrados</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>Quantidade de Copos de Agua</th>
												<th>Volume de Agua</th>
												<th>Observação de Agua</th>
												<th>Data de Registro</th>
												<th>Deletar</th>
											</tr>
										</thead>
									
										<tbody>
											<c:forEach items="${listaAgua}" var="rankec">
												<tr>
                                            	 <td>${rankec.qtaCopos}</td>
                                            	 <td>${rankec.vlmAgua} Litros</td>
                                            	 <td>${rankec.obsAgua}</td>
                                            	 <td>${rankec.dtAgua}</td>
                                            	 <td><a class="nav-link" href="http://localhost:8080/health/DeleteAgua?id=${rankec.cdAgua}&CodId=${CodId}"><i class="fas fa-fw fa-sign-in-alt"></i><span>Deletar</span></a></td>
                                            	 <tr>
                                            	</c:forEach>
                                            	
										</tbody>
									</table>
							</div>
						</div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; EchoDevs 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="cssboot/vendor/jquery/jquery.min.js"></script>
    <script src="cssboot/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="cssboot/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="cssboot/js/sb-admin-2.min.js"></script>

</body>

</html>