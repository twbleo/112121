-- src/main/resources/schema.sql
CREATE TABLE doctor (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        full_name VARCHAR(100),
                        crm VARCHAR(20),
                        username VARCHAR(50) UNIQUE,
                        password VARCHAR(100)
);

CREATE TABLE patient (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         full_name VARCHAR(100),
                         date_of_birth DATE,
                         cpf VARCHAR(20) UNIQUE,
                         health_plan VARCHAR(50)
);

CREATE TABLE pharmacy (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100),
                          cnpj VARCHAR(20) UNIQUE,
                          password VARCHAR(100)
);

CREATE TABLE prescription (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              doctor_id BIGINT,
                              patient_id BIGINT,
                              medication VARCHAR(100),
                              dosage VARCHAR(50),
                              quantity VARCHAR(20),
                              administration_route VARCHAR(50),
                              observations TEXT,
                              timestamp TIMESTAMP,
                              pharmacy_id BIGINT,
                              FOREIGN KEY (doctor_id) REFERENCES doctor(id),
                              FOREIGN KEY (patient_id) REFERENCES patient(id),
                              FOREIGN KEY (pharmacy_id) REFERENCES pharmacy(id)
);
