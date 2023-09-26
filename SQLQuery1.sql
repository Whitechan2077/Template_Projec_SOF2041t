USE  EduSys;
GO
CREATE TABLE ChuyenDe(
	MaCD nchar(5) PRIMARY KEY NOT NULL,
	TenCD nvarchar(50) NOT NULL,
	HocPhi Float not null,
	ThoiLuong int not null,
	Hinh varbinary(Max),
	Mota Nvarchar(255),
);
GO
CREATE TABLE NhanVien(
	MaNV NVARCHAR(20) PRIMARY KEY,
	MatKhau NVARCHAR(50),
	HoTen NVARCHAR(50),
	VaiTro BIT
);
GO
CREATE TABLE KhoaHoc
(
	MaKH int identity(1,1) PRIMARY KEY NOT nULL,
	MaCD nchar(5) FOREIGN KEY(MaCD) REFERENCES ChuyenDe(MaCD) NOT NULL,
	HocPhi Float NOT NUll,
	ThoiLuong int not null,
	NgayKG date not null,
	GhiChu nvarchar(50),
	MaNV NVARCHAR(20) FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV),
	NgayTao date DEFAULT GETDATE(),
);
GO
CREATE TABLE NguoiHoc(
	MaNH nvarchar(7) PRIMARY KEY,
	HoTen nvarchar(50) NOT NULL,
	GioiTinh bit NOT NULL,
	NgaySinh date NOT NULL,
	DienThoai varchar(24) NOT NULL,
	Email varchar(50) NOT NULL,
	GhiChu nvarchar(255),
	MaNV NVARCHAR(20) FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV),
	NgayDangKi date DEFAULT GETDATE()
);
GO
CREATE TABLE HocVien(
	MaHV int identity(1,1) PRIMARY KEY NOT nULL,
	MaKH int FOREIGN KEY(MaKH) REFERENCES KhoaHoc(MaKH) NOT nULL,
	MaNH nvarchar(7) FOREIGN KEY(MaNH) REFERENCES NguoiHoc(MaNH) NOT nULL,
	Diem FLOAT DEFAULT -1 NOT nULL
);
GO
SELECT * FROM NhanVien
