USE [DB_Cafe]
GO
/****** Object:  Table [dbo].[tblAdisyon]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblAdisyon](
	[AdisyonId] [int] IDENTITY(1,1) NOT NULL,
	[MasaId] [int] NOT NULL,
	[Tarih] [date] NOT NULL,
	[ToplamTutar] [float] NOT NULL,
	[Aktif] [bit] NOT NULL,
 CONSTRAINT [PK_tblAdisyon] PRIMARY KEY CLUSTERED 
(
	[AdisyonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblHesap]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblHesap](
	[HesapId] [int] IDENTITY(1,1) NOT NULL,
	[AdisyonId] [int] NOT NULL,
	[UrunId] [int] NOT NULL,
	[Miktar] [float] NOT NULL,
	[BirimFiyat] [float] NOT NULL,
	[SatırToplam] [float] NOT NULL,
 CONSTRAINT [PK_tblHesap] PRIMARY KEY CLUSTERED 
(
	[HesapId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblKategori]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKategori](
	[KategoriId] [int] IDENTITY(1,1) NOT NULL,
	[KategoriAd] [varchar](100) NOT NULL,
 CONSTRAINT [PK_tblKategori] PRIMARY KEY CLUSTERED 
(
	[KategoriId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblMasa]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMasa](
	[MasaId] [int] IDENTITY(1,1) NOT NULL,
	[MasaNo] [varchar](50) NOT NULL,
	[DoluBos] [bit] NOT NULL,
 CONSTRAINT [PK_tblMasa] PRIMARY KEY CLUSTERED 
(
	[MasaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUrun]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUrun](
	[UrunId] [int] IDENTITY(1,1) NOT NULL,
	[KategoriId] [int] NOT NULL,
	[Urunadi] [varchar](100) NOT NULL,
	[UrunBirimFiyati] [float] NOT NULL,
	[MiktarTipi] [nvarchar](10) NULL,
 CONSTRAINT [PK_tblUrun] PRIMARY KEY CLUSTERED 
(
	[UrunId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](50) NULL,
	[Password] [varchar](50) NULL,
	[Name] [varchar](50) NULL,
	[SurName] [varchar](50) NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblAdisyon] ON 

INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (62, 1, CAST(N'2019-05-07' AS Date), 36, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (63, 1, CAST(N'2019-05-07' AS Date), 5, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (64, 8, CAST(N'2019-05-07' AS Date), 31, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (65, 1, CAST(N'2019-05-08' AS Date), 90, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (66, 4, CAST(N'2019-05-08' AS Date), 25, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (67, 3, CAST(N'2019-05-08' AS Date), 25, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (68, 5, CAST(N'2019-05-08' AS Date), 65, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (69, 1, CAST(N'2019-05-12' AS Date), 90, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (70, 1, CAST(N'2019-05-13' AS Date), 0, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (71, 2, CAST(N'2019-05-13' AS Date), 0, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (72, 4, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (73, 4, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (74, 4, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (75, 8, CAST(N'2019-05-13' AS Date), 0, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (76, 6, CAST(N'2019-05-13' AS Date), 0, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (77, 4, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (78, 3, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (79, 3, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (80, 1, CAST(N'2019-05-13' AS Date), 35, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (81, 3, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (82, 5, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (83, 5, CAST(N'2019-05-13' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (84, 6, CAST(N'2019-05-13' AS Date), 0, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (85, 1, CAST(N'2019-05-13' AS Date), 21, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (86, 2, CAST(N'2019-05-13' AS Date), 5, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (87, 1, CAST(N'2019-05-13' AS Date), 7, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (88, 2, CAST(N'2019-05-13' AS Date), 32, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (89, 8, CAST(N'2019-05-13' AS Date), 210, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (90, 1, CAST(N'2019-05-13' AS Date), 30, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (91, 2, CAST(N'2019-05-13' AS Date), 0, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (92, 8, CAST(N'2019-05-13' AS Date), 2, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (93, 6, CAST(N'2019-05-15' AS Date), 30, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (94, 7, CAST(N'2019-05-15' AS Date), 70, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (95, 9, CAST(N'2019-05-20' AS Date), 30, 0)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (96, 6, CAST(N'2019-06-17' AS Date), 0, 1)
INSERT [dbo].[tblAdisyon] ([AdisyonId], [MasaId], [Tarih], [ToplamTutar], [Aktif]) VALUES (97, 7, CAST(N'2019-06-17' AS Date), 0, 1)
SET IDENTITY_INSERT [dbo].[tblAdisyon] OFF
SET IDENTITY_INSERT [dbo].[tblHesap] ON 

INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (166, 62, 15, 1, 21, 21)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (167, 62, 20, 1, 10, 10)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (168, 62, 11, 1, 5, 5)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (169, 63, 22, 1, 5, 5)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (170, 64, 15, 1, 21, 21)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (171, 64, 20, 1, 10, 10)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (172, 65, 20, 4, 10, 40)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (173, 65, 20, 4, 10, 40)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (174, 65, 20, 1, 10, 10)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (175, 66, 16, 1, 25, 25)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (176, 67, 20, 1, 10, 10)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (177, 67, 11, 2, 0, 0)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (178, 68, 15, 2, 0, 0)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (179, 69, 11, 1, 5, 5)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (180, 69, 16, 1, 25, 25)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (181, 69, 18, 2, 30, 60)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (182, 68, 22, 1, 5, 5)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (183, 68, 25, 1, 60, 60)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (184, 67, 9, 3, 5, 15)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (185, 70, 25, 1.5, 60, 90)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (186, 71, 14, 2, 0, 0)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (190, 80, 13, 1, 35, 35)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (201, 85, 15, 1, 21, 21)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (202, 86, 12, 1, 5, 5)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (203, 88, 14, 1, 25, 25)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (205, 88, 9, 2, 0, 0)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (206, 88, 10, 1, 7, 7)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (207, 87, 10, 1, 7, 7)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (208, 89, 25, 3.5, 60, 210)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (209, 90, 26, 1, 25, 25)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (210, 92, 23, 1, 2, 2)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (211, 90, 22, 1, 5, 5)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (213, 93, 20, 3, 10, 30)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (214, 94, 13, 2, 35, 70)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (215, 95, 20, 3, 10, 30)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (216, 96, 5, 2, 45, 90)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (217, 96, 10, 3, 7, 21)
INSERT [dbo].[tblHesap] ([HesapId], [AdisyonId], [UrunId], [Miktar], [BirimFiyat], [SatırToplam]) VALUES (218, 96, 22, 2, 5, 10)
SET IDENTITY_INSERT [dbo].[tblHesap] OFF
SET IDENTITY_INSERT [dbo].[tblKategori] ON 

INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (1, N'Ana Yemekler')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (2, N'Başlangıçlar')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (3, N'Kahvaltılar')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (4, N'Sıcak İçecekler')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (5, N'Soğuk İçecekler')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (6, N'Pizzalar')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (7, N'Burgerler')
INSERT [dbo].[tblKategori] ([KategoriId], [KategoriAd]) VALUES (9, N'Tatlılar')
SET IDENTITY_INSERT [dbo].[tblKategori] OFF
SET IDENTITY_INSERT [dbo].[tblMasa] ON 

INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (1, N'MASA-1', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (2, N'MASA-2', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (3, N'MASA-3', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (4, N'MASA-4', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (5, N'MASA-5', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (6, N'MASA-6', 1)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (7, N'MASA-7', 1)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (8, N'MASA-8', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (9, N'MASA-9', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (10, N'MASA-10', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (11, N'MASA-11', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (12, N'MASA-12', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (13, N'MASA-13', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (14, N'MASA-14', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (15, N'MASA 15', 0)
INSERT [dbo].[tblMasa] ([MasaId], [MasaNo], [DoluBos]) VALUES (34, N'MASA-17', 0)
SET IDENTITY_INSERT [dbo].[tblMasa] OFF
SET IDENTITY_INSERT [dbo].[tblUrun] ON 

INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (2, 1, N'Tavuk Şiş', 27, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (3, 1, N'Izgara Köfte', 27, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (4, 2, N'Çin Böreği', 16, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (5, 2, N'Karides', 45, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (6, 2, N'Fırında Kaşarlı Mantar', 25, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (7, 3, N'Klasik Kahvaltı Tabağı', 26, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (8, 3, N'Miyansera Kahvaltı Tabağı', 35, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (9, 4, N'Çay', 5, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (10, 4, N'Ihlamur', 7, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (11, 5, N'Kola', 5, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (12, 5, N'Fanta', 5, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (13, 6, N'Karışık Pizza', 35, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (14, 6, N'İtalyan Pizza', 25, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (15, 7, N'CheeseBurger', 21, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (16, 7, N'ChickenBurger', 25, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (18, 9, N'Baklava', 30, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (20, 9, N'Sütlaç', 10, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (21, 4, N'Türk Kahvesi', 15, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (22, 5, N'Ice Tea', 5, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (23, 4, N'Oralet', 2, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (24, 5, N'Gazoz', 5, N'Adet')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (25, 9, N'Fıstık Sarması', 60, N'Porsiyon')
INSERT [dbo].[tblUrun] ([UrunId], [KategoriId], [Urunadi], [UrunBirimFiyati], [MiktarTipi]) VALUES (26, 9, N'Kadayıf', 25, N'Porsiyon')
SET IDENTITY_INSERT [dbo].[tblUrun] OFF
SET IDENTITY_INSERT [dbo].[tblUser] ON 

INSERT [dbo].[tblUser] ([userId], [UserName], [Password], [Name], [SurName]) VALUES (2, N'mrtcnk', N'123', N'Mertcan', N'kıratlı')
INSERT [dbo].[tblUser] ([userId], [UserName], [Password], [Name], [SurName]) VALUES (7, N'admin', N'321', N'Uğurcan', N'Söylemez')
SET IDENTITY_INSERT [dbo].[tblUser] OFF
ALTER TABLE [dbo].[tblAdisyon] ADD  CONSTRAINT [DF_tblAdisyon_MasaId]  DEFAULT ((0)) FOR [MasaId]
GO
ALTER TABLE [dbo].[tblAdisyon] ADD  CONSTRAINT [DF_tblAdisyon_Tarih]  DEFAULT (NULL) FOR [Tarih]
GO
ALTER TABLE [dbo].[tblAdisyon] ADD  CONSTRAINT [DF_tblAdisyon_ToplamTutar]  DEFAULT ((0)) FOR [ToplamTutar]
GO
ALTER TABLE [dbo].[tblAdisyon] ADD  CONSTRAINT [DF_tblAdisyon_Aktif]  DEFAULT ((1)) FOR [Aktif]
GO
ALTER TABLE [dbo].[tblHesap] ADD  CONSTRAINT [DF_tblHesap_AdisyonId]  DEFAULT ((0)) FOR [AdisyonId]
GO
ALTER TABLE [dbo].[tblHesap] ADD  CONSTRAINT [DF_tblHesap_UrunId]  DEFAULT ((0)) FOR [UrunId]
GO
ALTER TABLE [dbo].[tblHesap] ADD  CONSTRAINT [DF_tblHesap_Miktar]  DEFAULT ((1)) FOR [Miktar]
GO
ALTER TABLE [dbo].[tblHesap] ADD  CONSTRAINT [DF_tblHesap_BirimFiyat]  DEFAULT ((0)) FOR [BirimFiyat]
GO
ALTER TABLE [dbo].[tblHesap] ADD  CONSTRAINT [DF_tblHesap_SatırToplam]  DEFAULT ((0)) FOR [SatırToplam]
GO
ALTER TABLE [dbo].[tblKategori] ADD  CONSTRAINT [DF_tblKategori_KategoriAd]  DEFAULT ('') FOR [KategoriAd]
GO
ALTER TABLE [dbo].[tblMasa] ADD  CONSTRAINT [DF_tblMasa_MasaNo]  DEFAULT ('') FOR [MasaNo]
GO
ALTER TABLE [dbo].[tblMasa] ADD  CONSTRAINT [DF_tblMasa_DoluBos]  DEFAULT ((0)) FOR [DoluBos]
GO
ALTER TABLE [dbo].[tblUrun] ADD  CONSTRAINT [DF_tblUrun_KategoriId]  DEFAULT ((0)) FOR [KategoriId]
GO
ALTER TABLE [dbo].[tblUrun] ADD  CONSTRAINT [DF_tblUrun_Urunadi]  DEFAULT ('') FOR [Urunadi]
GO
ALTER TABLE [dbo].[tblUrun] ADD  CONSTRAINT [DF_tblUrun_UrunBirimFiyati]  DEFAULT ((0)) FOR [UrunBirimFiyati]
GO
ALTER TABLE [dbo].[tblAdisyon]  WITH CHECK ADD  CONSTRAINT [FK_tblAdisyon_tblMasa] FOREIGN KEY([MasaId])
REFERENCES [dbo].[tblMasa] ([MasaId])
GO
ALTER TABLE [dbo].[tblAdisyon] CHECK CONSTRAINT [FK_tblAdisyon_tblMasa]
GO
ALTER TABLE [dbo].[tblHesap]  WITH CHECK ADD  CONSTRAINT [FK_tblHesap_tblAdisyon] FOREIGN KEY([AdisyonId])
REFERENCES [dbo].[tblAdisyon] ([AdisyonId])
GO
ALTER TABLE [dbo].[tblHesap] CHECK CONSTRAINT [FK_tblHesap_tblAdisyon]
GO
ALTER TABLE [dbo].[tblHesap]  WITH CHECK ADD  CONSTRAINT [FK_tblHesap_tblUrun] FOREIGN KEY([UrunId])
REFERENCES [dbo].[tblUrun] ([UrunId])
GO
ALTER TABLE [dbo].[tblHesap] CHECK CONSTRAINT [FK_tblHesap_tblUrun]
GO
ALTER TABLE [dbo].[tblUrun]  WITH CHECK ADD  CONSTRAINT [FK_tblUrun_tblKategori] FOREIGN KEY([KategoriId])
REFERENCES [dbo].[tblKategori] ([KategoriId])
GO
ALTER TABLE [dbo].[tblUrun] CHECK CONSTRAINT [FK_tblUrun_tblKategori]
GO
/****** Object:  StoredProcedure [dbo].[spAdisyonGetir]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE proc [dbo].[spAdisyonGetir]
 @MasaId int
 as
 select h.HesapId,u.UrunId,u.Urunadi,u.UrunBirimFiyati,h.Miktar,u.MiktarTipi,h.SatırToplam from tblAdisyon a
 inner join tblHesap h on h.AdisyonId=a.AdisyonId
 inner join tblUrun u on u.UrunId=h.UrunId
 where a.Aktif=1 and MasaId=@MasaId
GO
/****** Object:  StoredProcedure [dbo].[spAdisyonKapat]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spAdisyonKapat]
 @toplamTutar float,
 @masaId int
 as
update tblAdisyon set Aktif=0,ToplamTutar=@toplamTutar where AdisyonId=(select a.AdisyonId from tblAdisyon a inner join tblMasa m on m.MasaId=a.MasaId where m.MasaId=@masaId and a.Aktif=1)








GO
/****** Object:  StoredProcedure [dbo].[spAdisyonUrunEkle]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spAdisyonUrunEkle]
@MasaId int,
@UrunId int,
@BirimFiyat float,
@Miktar float
as 
declare  @SatırToplam  float
set @SatırToplam=@BirimFiyat*@Miktar
insert into tblHesap (AdisyonId,UrunId,BirimFiyat,Miktar,SatırToplam) 
values ((select a.AdisyonId from tblAdisyon a inner join tblMasa m on m.MasaId=a.MasaId where m.MasaId=@MasaId and a.Aktif=1),@UrunId,@BirimFiyat,@Miktar,@SatırToplam)

GO
/****** Object:  StoredProcedure [dbo].[spAdisyonUrunGuncelle]    Script Date: 14.7.2019 11:40:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[spAdisyonUrunGuncelle]
@HesapId int,
@UrunId int,
@BirimFiyat float,
@Miktar float
as
declare @SatırToplam float
update tblHesap set UrunId=@UrunId,BirimFiyat=@BirimFiyat,Miktar=@Miktar,@SatırToplam=@BirimFiyat*@Miktar,SatırToplam=@SatırToplam
where HesapId=@HesapId
GO
