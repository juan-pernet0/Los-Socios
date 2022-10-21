<%@include file="Icono.jsp"%> 
<!doctype html>

<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <link rel="stylesheet" href="style.css">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale=1.0, minimun-scale=1.0">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Index</title>
    </head>
    <body>

        <div class="main-index">
            <nav class="navbar navbar-expand-lg navbar navbar-light" style="background-color: #e3f2fd;">            
                <a class="navbar-brand">
                    <img src="https://cdn.icon-icons.com/icons2/1410/PNG/128/5_97257.png" alt="" width="40" height="40" class="d-inline-block align-text-top">
                </a>
                <div class="links-navbar-index">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="./ControlPrecios">Precios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="RegistrarUsuario.jsp">Crear Cuenta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"  href="./ControlLogin">Iniciar Sesion</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <h1>Empresas Distribuidoras</h1>

            <section class="cards">
                <div class="card">
                    <div class="imagen-cartas">
                        <img class="card-img-top img-fluid" src="http://roscogas.com.co/images/logo%20nuevo.png"  alt="Card image cap">
                    </div>
                    <div class="card-body">
                        <div class="Titulo-Carta">
                            <h5 class="card-title">Rosco Gas</h5>
                        </div>
                        <div class="Parrafo-Carta">
                            <p class="card-text">Es un Grupo empresarial con capital Antioqueño que se dedica al tartamiento del petróleo refinado Para obtener gas.</p>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="imagen-cartas">
                        <img class="card-img-top img-fluid" src="https://linkempleo.co/wp-content/uploads/2018/11/descarga.png"  alt="Card image cap">
                    </div>
                    <div class="card-body">
                        <div class="Titulo-Carta">
                            <h5 class="card-title">Gases de Antioquia</h5>
                        </div>
                        <div class="Parrafo-Carta">
                            <p class="card-text">Es una empresa, dedicada a la distribución de gas propano, en el territorio antioqueño y sus cercanias.</p>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="imagen-cartas">
                        <img class="card-img-top img-fluid" src="https://www.gazclc.com/site/wp-content/uploads/2021/05/Mesa-de-trabajo-1-1.png"  alt="Card image cap">
                    </div>
                    <div class="card-body">
                        <div class="Titulo-Carta">
                            <h5 class="card-title">Gaz</h5>
                        </div>
                        <div class="Parrafo-Carta">
                            <p class="card-text">Es un compañia que hace presencia en más de 32 ciudades, 24 municipios, del terrirorio colombiano.</p>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="imagen-cartas">
                        <img class="card-img-top img-fluid" src="https://gasco.ines.cl/gasco/formulario/vidagas/images/header_logo.png"  alt="Card image cap">
                    </div>
                    <div class="card-body">
                        <div class="Titulo-Carta">
                            <h5 class="card-title">Vida Gas</h5>
                        </div>
                        <div class="Parrafo-Carta">
                            <p class="card-text">Es una compañía chilena con más de 160 años de trayectoria. Nuestra marca Vidagas en Colombia.</p>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="imagen-cartas">
                        <img class="card-img-top img-fluid" src="https://gaspais.com.co/wp-content/uploads/2020/08/LOGO-GAS-PAIS.png"  alt="Card image cap">
                    </div>
                    <div class="card-body">
                        <div class="Titulo-Carta">
                            <h5 class="card-title">Gas Pais</h5>
                        </div>
                        <div class="Parrafo-Carta">
                            <p class="card-text">Empresa dedicada a entregar soluciones energéticas integrales a sus clientes.</p>
                        </div>
                    </div>
                </div>
            </section>

            <div class="main-mapa">
                <h1>¿Como llegar?</h1>
                <div class="mapa">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d991.4681463815562!2d-75.33301531525329!3d6.280476617182861!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e441f218d7a72df%3A0x14237dd9f551f243!2sTalleres%20La%20Virgen!5e0!3m2!1ses!2sco!4v1637653113518!5m2!1ses!2sco" width="1300" height="500" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                </div>
            </div>

            <div class="iconos">
                <div class="icono">
                    <img src="iconos/Cilindro.png" alt="" width="60px" height="100px"/>
                    <p>Cilindros</p>
                </div>
                 <div class="icono">
                    <img src="iconos/Domicilio.png" alt="" width="60px" height="90px"/>
                    <p>Domicilios</p>
                </div>
                <div class="icono">
                    <img src="iconos/Ubicacion.png" alt="" width="60px" height="80px"/>
                    <p>Almacen</p>
                </div>
                <div class="icono">
                    <img src="iconos/Telefono.png" alt="" width="70px" height="90px"/>
                    <p>Pedidos Por Telfono</p>
                </div>
            </div>

            <div class="container-fluid bg-inverse text-white py-3" style="background-color: #4a8ccfd9;">
                <div class="container text-center">
                    <p>Todos los dereechos Reservados ©</p>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        -->
    </body>
</html>