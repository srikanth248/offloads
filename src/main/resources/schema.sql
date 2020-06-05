DROP TABLE IF EXISTS offload;

CREATE TABLE offload (
    id INT PRIMARY KEY,
    barcode varchar2(40),
    offload_type varchar2(40)
);