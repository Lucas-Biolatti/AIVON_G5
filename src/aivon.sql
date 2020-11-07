-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2020 a las 20:29:08
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aivon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camp`
--

CREATE TABLE `camp` (
  `idCamp` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaCierre` date NOT NULL,
  `montoMin` double NOT NULL,
  `montoMax` double NOT NULL,
  `estadoCamp` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `camp`
--

INSERT INTO `camp` (`idCamp`, `fechaInicio`, `fechaCierre`, `montoMin`, `montoMax`, `estadoCamp`) VALUES
(1, '2020-04-01', '2020-04-26', 5000, 8000, 0),
(2, '2020-07-01', '2020-07-26', 5000, 8000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedido`
--

CREATE TABLE `detallepedido` (
  `idDetalle` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallepedido`
--

INSERT INTO `detallepedido` (`idDetalle`, `idPedido`, `idProducto`) VALUES
(4, 2, 3),
(5, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaEntrega` date DEFAULT NULL,
  `fechaPago` date DEFAULT NULL,
  `cantCajas` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idRevendedora` int(11) NOT NULL,
  `idCamp` int(11) NOT NULL,
  `importe` double DEFAULT NULL,
  `estrellasPedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `fechaIngreso`, `fechaEntrega`, `fechaPago`, `cantCajas`, `estado`, `idRevendedora`, `idCamp`, `importe`, `estrellasPedido`) VALUES
(2, '2020-04-05', '2020-04-10', '2020-04-30', 2, 1, 2, 1, NULL, 50),
(3, '2020-04-07', '2020-04-30', '2020-04-14', 2, 1, 2, 1, NULL, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProd` varchar(30) NOT NULL,
  `uso` varchar(20) NOT NULL,
  `tamañoCm3` int(11) NOT NULL,
  `precioVenta` double NOT NULL,
  `precioCosto` double NOT NULL,
  `aporteEst` int(11) NOT NULL,
  `estadoProducto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProd`, `uso`, `tamañoCm3`, `precioVenta`, `precioCosto`, `aporteEst`, `estadoProducto`) VALUES
(1, 'Lapiz Labial rojo', 'corporal', 60, 50, 45, 1, 1),
(2, 'Perfume Hombre', 'corporal', 60, 2000, 1700, 10, 1),
(3, 'Crema de Afeitar', 'Cara', 50, 500, 450, 5, 1),
(4, 'Crema de mano', 'diurno', 30, 100, 85, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revendedora`
--

CREATE TABLE `revendedora` (
  `idRevendedora` int(11) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `nombreCompleto` varchar(11) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `revendedora`
--

INSERT INTO `revendedora` (`idRevendedora`, `telefono`, `mail`, `nombreCompleto`, `dni`, `estado`, `nivel`) VALUES
(1, '2262656545', 'fasdfasd@sdfds.com', 'Maria, Chus', '32158548', 1, 1),
(2, '2154678352', 'kjhksjdhg@dsf.com', 'Maria', '37592474', 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `camp`
--
ALTER TABLE `camp`
  ADD PRIMARY KEY (`idCamp`);

--
-- Indices de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `idPedido` (`idPedido`,`idProducto`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `relacion` (`idRevendedora`),
  ADD KEY `idCamp` (`idCamp`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `revendedora`
--
ALTER TABLE `revendedora`
  ADD PRIMARY KEY (`idRevendedora`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `camp`
--
ALTER TABLE `camp`
  MODIFY `idCamp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `revendedora`
--
ALTER TABLE `revendedora`
  MODIFY `idRevendedora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idRevendedora`) REFERENCES `revendedora` (`idRevendedora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idCamp`) REFERENCES `camp` (`idCamp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
