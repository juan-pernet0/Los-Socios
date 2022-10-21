<%-- 
    Document   : Estadisticas
    Created on : 21/09/2021, 06:26:44 PM
    Author     : user
--%>

<%@page import="dto.DTORol"%>
<%@page import="dto.DTOEstadisticas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estadisticas</title>
        <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Estadisticas</h1> 
        <div class="main-estadisticas">

            <h2>Numero de pedidos de cilindros por cliente</h2>
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Usuarios</th>
                                <th>N° de Cilindros Pedidos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Primera_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Primera_Consulta");
                                for (int i = 0; i < Lista_Primera_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Primera_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Primera_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Cantidad de Registros" class="form-control" min="1" name="cantidad" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="PrimeraConsulta">Limitar</button>
                        </form>
                    </div>

                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=PrimerReporte"> Generar Reporte</a></button>
                </div>
                <div id="barras" class="grafico"></div>
            </div>


            <h2>Numero de Pedidos por Mes</h2>      
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Meses</th>
                                <th>N° de Cilindros Pedidos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Segunda_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Segunda_Consulta");
                                for (int i = 0; i < Lista_Segunda_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Segunda_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Segunda_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="date" class="form-control" name="FechaIncial" required="">
                            <input type="date" class="form-control" name="FechaFinal" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="SegundaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=SegundoReporte"> Generar Reporte</a></button>
                </div>
                <div id="grafico" class="grafico"></div>

            </div>  

            <h2>Pedidos hechos por cliente</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Clientes</th>
                                <th>N° de pedidos hechos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Tercera_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Tercera_Consulta");
                                for (int i = 0; i < Lista_Tercera_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Tercera_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Tercera_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Cantidad de Registros" class="form-control" min="1" name="cantidad" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="TerceraConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=TercerReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Tercera_Consulta" class="grafico"></div>
            </div>

            <h2>Pedidos hechos por empresa</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Empresa</th>
                                <th>N° de pedidos hechos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Cuarta_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Cuarta_Consulta");
                                for (int i = 0; i < Lista_Cuarta_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Cuarta_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Cuarta_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Cantidad de Registros" class="form-control" min="1" name="cantidad" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="CuartaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=CuartoReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Cuarta_Consulta" class="grafico"></div>
            </div>




            <h2>Pedidos por dia</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Dia</th>
                                <th>N° de pedidos hechos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Quinta_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Quinta_Consulta");
                                for (int i = 0; i < Lista_Quinta_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Quinta_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Quinta_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="date" class="form-control" name="FechaIncial" required="">
                            <input type="date" class="form-control" name="FechaFinal" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="QuintaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=QuintoReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Quinta_Consulta" class="grafico"></div>
            </div>


            <h2>Pedidos por semana</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Semana/Año</th>
                                <th>N° de pedidos hechos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Sexta_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Sexta_Consulta");
                                for (int i = 0; i < Lista_Sexta_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Sexta_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Sexta_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="date" class="form-control" name="FechaIncial" required="">
                            <input type="date" class="form-control" name="FechaFinal" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="SextaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=SextoReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Sexta_Consulta" class="grafico"></div>
            </div>


            <h2>Promedio Cilidros Pedidos Por Cliente</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Cliente</th>
                                <th>Promedio de Cilindros Pedidos</th>
                            </tr>
                            <%
                                List<DTORol> Lista_Septima_Consulta = (List<DTORol>) request.getAttribute("Lista_Septima_Consulta");
                                for (int i = 0; i < Lista_Septima_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Septima_Consulta.get(i).getRol() + "</td>");
                                    out.print("<td>" + Lista_Septima_Consulta.get(i).getNombres() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Cantidad de Registros" class="form-control" min="1" name="cantidad" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="SeptimaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=SeptimoReporte"> Generar Reporte</a></button>
                </div>
            </div>

            <h2>Cantidad de Usuarios Registrados en el Sistema</h2> 
            <div class="conatiner_estadistica">
                <%
                    int Octava_Consulta = (int) request.getAttribute("Octava_Consulta");
                    out.print("<h2 class='Octava_Consulta'>" + Octava_Consulta + "</h2> ");
                %>
            </div>


            <h2>Pedidos asignados a empleados</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Empleado</th>
                                <th>N° de Cilindros Asignados</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Novena_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Novena_Consulta");
                                for (int i = 0; i < Lista_Septima_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Novena_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Novena_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Cantidad de Registros" class="form-control" min="1" name="cantidad" required="">
                            <button type="submit" class="btn btn-success" name="accion" value="NovenaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=NovenoReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Novena_Consulta" class="grafico"></div>
            </div>


            <h2>Pedidos por hora</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Hora</th>
                                <th>N° de Pedidos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Decima_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Decima_Consulta");
                                for (int i = 0; i < Lista_Decima_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Decima_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Decima_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Horas" class="form-control" min="1" name="cantidad" required="" max="24">
                            <button type="submit" class="btn btn-success" name="accion" value="DecimaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=DecimoReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Decima_Consulta" class="grafico"></div>
            </div>

            <h2>Pedidos por dia de la semana</h2> 
            <div class="conatiner_estadistica">
                <div class="Tabla-Consulta">
                    <table class='table table-bordered'>
                        <tbody>
                        <thead>
                            <tr>
                                <th>Dia</th>
                                <th>N° de Pedidos</th>
                            </tr>
                            <%
                                List<DTOEstadisticas> Lista_Undecima_Consulta = (List<DTOEstadisticas>) request.getAttribute("Lista_Undecima_Consulta");
                                for (int i = 0; i < Lista_Undecima_Consulta.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + Lista_Undecima_Consulta.get(i).getFecha() + "</td>");
                                    out.print("<td>" + Lista_Undecima_Consulta.get(i).getNumero_de_pedidos() + "</td>");
                                    out.print("</tr>");
                                }
                            %>
                        </thead>
                        </tbody>
                    </table>
                    <div class="Formulario-Consulta">
                        <form action="ControlEstadisticas" method="Post">
                            <input type="number" placeholder="Dias" class="form-control" min="1" name="cantidad" required="" max="7">
                            <button type="submit" class="btn btn-success" name="accion" value="UndecimaConsulta">Limitar</button>
                        </form>
                    </div>
                </div>
                <div class="boton-pdf">
                    <button type="button" class="btn btn-danger"><i class="fas fa-file-pdf"></i><a href="ControlEstadisticas?accion=UndecimoReporte"> Generar Reporte</a></button>
                </div>
                <div id="Lista_Undecima_Consulta" class="grafico"></div>
            </div>
        </div>
        <%
            List<DTOEstadisticas> listaMeses = (List<DTOEstadisticas>) request.getAttribute("Lista_Segunda_Consulta");

            out.print("<script type='text/javascript'>");
            out.print("var parametros = [];");
            out.print("var valores = [];");
            out.print("parametros.push('');");
            out.print("valores.push(parseInt(0));");

            for (int i = 0; i < listaMeses.size(); i++) {
                out.print("parametros.push('" + listaMeses.get(i).getFecha() + "');");
                out.print("valores.push(parseInt('" + listaMeses.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var data = [{");
            out.print("x: parametros,");
            out.print("y: valores,");
            out.print("type: 'linear'");
            out.print("}];");
            out.print("Plotly.newPlot('grafico',data);");

            /*Clientes*/
            List<DTOEstadisticas> listaClientes = (List<DTOEstadisticas>) request.getAttribute("Lista_Primera_Consulta");

            out.print("var clientes = [];");
            out.print("var pedidos = [];");

            for (int i = 0; i < listaClientes.size(); i++) {
                out.print("clientes.push('" + listaClientes.get(i).getFecha() + "');");
                out.print("pedidos.push(parseInt('" + listaClientes.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var barras = [{");
            out.print("x: clientes,");
            out.print("y: pedidos,");
            out.print("type: 'bar'");
            out.print("}];");
            out.print("Plotly.newPlot('barras',barras);");

            /*Pedidos Clientes*/
            out.print("var Lista_Tercera_Consulta1 = [];");
            out.print("var Lista_Tercera_Consulta2 = [];");

            for (int i = 0; i < Lista_Tercera_Consulta.size(); i++) {
                out.print("Lista_Tercera_Consulta1.push('" + Lista_Tercera_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Tercera_Consulta2.push(parseInt('" + Lista_Tercera_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Tercera_Consulta = [{");
            out.print("x: Lista_Tercera_Consulta1,");
            out.print("y: Lista_Tercera_Consulta2,");
            out.print("type: 'bar'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Tercera_Consulta',Lista_Tercera_Consulta);");

            /*Empresas Pedidos*/
            out.print("var Lista_Cuarta_Consulta1 = [];");
            out.print("var Lista_Cuarta_Consulta2 = [];");

            for (int i = 0; i < Lista_Cuarta_Consulta.size(); i++) {
                out.print("Lista_Cuarta_Consulta1.push('" + Lista_Cuarta_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Cuarta_Consulta2.push(parseInt('" + Lista_Cuarta_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Cuarta_Consulta = [{");
            out.print("x: Lista_Cuarta_Consulta1,");
            out.print("y: Lista_Cuarta_Consulta2,");
            out.print("type: 'bar'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Cuarta_Consulta',Lista_Cuarta_Consulta);");

            /*Dias Pedidos*/
            out.print("var Lista_Quinta_Consulta1 = [];");
            out.print("var Lista_Quinta_Consulta2 = [];");

            for (int i = 0; i < Lista_Quinta_Consulta.size(); i++) {
                out.print("Lista_Quinta_Consulta1.push('" + Lista_Quinta_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Quinta_Consulta2.push(parseInt('" + Lista_Quinta_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Quinta_Consulta = [{");
            out.print("x: Lista_Quinta_Consulta1,");
            out.print("y: Lista_Quinta_Consulta2,");
            out.print("type: 'linear'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Quinta_Consulta',Lista_Quinta_Consulta);");

            /*Semanas Pedidos*/
            out.print("var Lista_Sexta_Consulta1 = [];");
            out.print("var Lista_Sexta_Consulta2 = [];");

            for (int i = 0; i < Lista_Sexta_Consulta.size(); i++) {
                out.print("Lista_Sexta_Consulta1.push('" + Lista_Sexta_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Sexta_Consulta2.push(parseInt('" + Lista_Sexta_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Sexta_Consulta = [{");
            out.print("x: Lista_Sexta_Consulta1,");
            out.print("y: Lista_Sexta_Consulta2,");
            out.print("type: 'linear'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Sexta_Consulta',Lista_Sexta_Consulta);");


            /*Empleados Pedidos Asignados*/
            out.print("var Lista_Novena_Consulta1 = [];");
            out.print("var Lista_Novena_Consulta2 = [];");

            for (int i = 0; i < Lista_Novena_Consulta.size(); i++) {
                out.print("Lista_Novena_Consulta1.push('" + Lista_Novena_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Novena_Consulta2.push(parseInt('" + Lista_Novena_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Novena_Consulta = [{");
            out.print("x: Lista_Novena_Consulta1,");
            out.print("y: Lista_Novena_Consulta2,");
            out.print("type: 'bar'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Novena_Consulta',Lista_Novena_Consulta);");

            /*Hora N° Pedidos*/
            out.print("var Lista_Decima_Consulta1 = [];");
            out.print("var Lista_Decima_Consulta2 = [];");

            for (int i = 0; i < Lista_Decima_Consulta.size(); i++) {
                out.print("Lista_Decima_Consulta1.push('" + Lista_Decima_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Decima_Consulta2.push(parseInt('" + Lista_Decima_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Decima_Consulta = [{");
            out.print("x: Lista_Decima_Consulta1,");
            out.print("y: Lista_Decima_Consulta2,");
            out.print("type: 'linear'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Decima_Consulta',Lista_Decima_Consulta);");
            
            /*Hora N° Pedidos*/
            out.print("var Lista_Undecima_Consulta1 = [];");
            out.print("var Lista_Undecima_Consulta2 = [];");

            for (int i = 0; i < Lista_Undecima_Consulta.size(); i++) {
                out.print("Lista_Undecima_Consulta1.push('" + Lista_Undecima_Consulta.get(i).getFecha() + "');");
                out.print("Lista_Undecima_Consulta2.push(parseInt('" + Lista_Undecima_Consulta.get(i).getNumero_de_pedidos() + "'));");

            }
            out.print("var Lista_Undecima_Consulta = [{");
            out.print("x: Lista_Undecima_Consulta1,");
            out.print("y: Lista_Undecima_Consulta2,");
            out.print("type: 'linear'");
            out.print("}];");
            out.print("Plotly.newPlot('Lista_Undecima_Consulta',Lista_Undecima_Consulta);");

            out.print("</script>");
        %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    </body>
</html>
