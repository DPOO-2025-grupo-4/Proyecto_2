/**
 * 
 */
/**
 * 
 */
module Proyecto_DPO {
	requires org.junit.jupiter.api;
	requires com.google.gson;
	opens Eventos to com.google.gson;
    opens Usuarios to com.google.gson;
    opens tiquetes to com.google.gson;
    opens Sistema to com.google.gson;
    opens repositorios to com.google.gson;
}