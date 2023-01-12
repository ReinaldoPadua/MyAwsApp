--
-- Estrutura da tabela `music`
--

CREATE TABLE `music` (
                         `id` bigint NOT NULL,
                         `album` varchar(255) DEFAULT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `style_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `music_seq`
--

CREATE TABLE `music_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `music_seq`
--

INSERT INTO `music_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `style`
--

CREATE TABLE `style` (
                         `id` bigint NOT NULL,
                         `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `style_seq`
--

CREATE TABLE `style_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `style_seq`
--

INSERT INTO `style_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `version`
--

CREATE TABLE `version` (
                           `id` bigint NOT NULL,
                           `label` varchar(255) DEFAULT NULL,
                           `music_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `version_seq`
--

CREATE TABLE `version_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `version_seq`
--

INSERT INTO `version_seq` (`next_val`) VALUES
    (1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `music`
--
ALTER TABLE `music`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK3992xbafmrsuwa3vk67khuxtt` (`style_id`);

--
-- Índices para tabela `style`
--
ALTER TABLE `style`
    ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `version`
--
ALTER TABLE `version`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKjywp4thptcy0ppii8cdqwyg01` (`music_id`);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `music`
--
ALTER TABLE `music`
    ADD CONSTRAINT `FK3992xbafmrsuwa3vk67khuxtt` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`);

--
-- Limitadores para a tabela `version`
--
ALTER TABLE `version`
    ADD CONSTRAINT `FKjywp4thptcy0ppii8cdqwyg01` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`);
COMMIT;

INSERT INTO `style`(`id`,`name`) VALUES (1,'ROCK');
INSERT INTO `style`(`id`,`name`) VALUES (2,'METAL');
INSERT INTO `style`(`id`,`name`) VALUES (3,'PUNK');
INSERT INTO `style`(`id`,`name`) VALUES (4,'JAZZ');

