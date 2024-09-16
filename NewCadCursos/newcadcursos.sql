-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05-Set-2024 às 13:55
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `newcadcursos`
--
-- CREATE DATABASE `NewCadCursos`;
-- --------------------------------------------------------
--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `IdAluno` int(11) NOT NULL,
  `NomeAluno` varchar(255) NOT NULL,
  `DataNasc` varchar(10) NOT NULL,
  `Genero` varchar(9) NOT NULL,
  `Endereco` varchar(255) NOT NULL,
  `Telefone` varchar(15) NOT NULL,
  `DataMatricula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`IdAluno`, `NomeAluno`, `DataNasc`, `Genero`, `Endereco`, `Telefone`, `DataMatricula`) VALUES
(1, 'Carlos Alberto', '01/01/1979', 'Masculino', 'Av. Águia de Haia, 001', '91111-1111', '02/02/2022'),
(2, 'Maria Luiza Passo Silva', '11/02/2007', 'Feminino', 'Rua Domingues, 350', '(11) 90219-9291', '20/05/2020'),
(3, 'Matheus Lima', '05/10/2005', 'Masculino', 'Av. dos Bandeirantes, 790', '(19) 90192-0101', '09/08/2021'),
(4, 'Tatiante Guzman', '27/07/2006', 'Feminino', 'Travessa dos Ladrilihos, 372', '(11) 98229-3321', '02/06/2022');

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `IdCurso` int(11) NOT NULL,
  `NomeCurso` varchar(255) NOT NULL,
  `QuantTurmas` int(11) DEFAULT NULL,
  `DataInicio` varchar(10) NOT NULL,
  `DataTermino` varchar(10) NOT NULL,
  `CargaHoraria` varchar(10) NOT NULL,
  `Preco` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `IdProfessor` int(11) NOT NULL,
  `NomeProf` varchar(255) NOT NULL,
  `PDataNasc` varchar(10) NOT NULL,
  `PGenero` varchar(9) NOT NULL,
  `PEndereco` varchar(255) NOT NULL,
  `PTelefone` varchar(15) NOT NULL,
  `ProfEmail` varchar(255) NOT NULL,
  `ValorHoraAula` varchar(10) NOT NULL,
  `DataContrato` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblusuario`
--

CREATE TABLE `tblusuario` (
  `usuario` varchar(25) NOT NULL,
  `senha` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblusuario`
--

INSERT INTO `tblusuario` (`usuario`, `senha`) VALUES
('malu', '918'),
('joaoV', '112'),
('maluZ', '999'),
('Carlos', '1234'),
('joao2', '1234'),
('joao3', 'joao34');

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `IdTurma` int(11) NOT NULL,
  `QtdAlunos` int(11) DEFAULT NULL,
  `IdProfessor` int(11) NOT NULL,
  `IdAluno` int(11) NOT NULL,
  `IdCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`IdAluno`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`IdCurso`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`IdProfessor`);

--
-- Índices para tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`IdTurma`),
  ADD KEY `IdProfessor` (`IdProfessor`),
  ADD KEY `IdAluno` (`IdAluno`),
  ADD KEY `IdCurso` (`IdCurso`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `IdTurma` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `turma_ibfk_1` FOREIGN KEY (`IdProfessor`) REFERENCES `professor` (`IdProfessor`),
  ADD CONSTRAINT `turma_ibfk_2` FOREIGN KEY (`IdAluno`) REFERENCES `aluno` (`IdAluno`),
  ADD CONSTRAINT `turma_ibfk_3` FOREIGN KEY (`IdCurso`) REFERENCES `curso` (`IdCurso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
