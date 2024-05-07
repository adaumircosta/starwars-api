-- Use explicit transactions and error handling
SET autocommit = 0;
START TRANSACTION;

-- Drop existing tables if they exist to avoid conflicts during schema creation
DROP TABLE IF EXISTS film_person, film_planet, film_species, film_vehicle, film_starship, person_vehicle, person_starship, person_species, planets_people;
DROP TABLE IF EXISTS films, people, planets, species, vehicles, starships;

-- Creating films table
CREATE TABLE films (
    film_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    episode_id INT NOT NULL,
    opening_crawl TEXT,
    director VARCHAR(100) NOT NULL,
    producer VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    url VARCHAR(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    edited TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating Planets table
CREATE TABLE planets (
    planet_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    rotation_period INT,
    orbital_period INT,
    diameter INT,
    climate VARCHAR(100),
    gravity VARCHAR(100),
    terrain VARCHAR(100),
    surface_water INT,
    population BIGINT,
    url VARCHAR(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    edited TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating People table
CREATE TABLE people (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    height INT,
    mass INT,
    hair_color VARCHAR(50),
    skin_color VARCHAR(50),
    eye_color VARCHAR(50),
    birth_year VARCHAR(10),
    gender VARCHAR(10),
    homeworld INT,
    url VARCHAR(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    edited TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (homeworld) REFERENCES planets(planet_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Creating Species table
CREATE TABLE species (
    species_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    classification VARCHAR(50),
    designation VARCHAR(50),
    average_height INT,
    skin_colors VARCHAR(255),
    hair_colors VARCHAR(255),
    eye_colors VARCHAR(255),
    average_lifespan INT,
    homeworld INT,
    language VARCHAR(100),
    url VARCHAR(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    edited TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (homeworld) REFERENCES planets(planet_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Creating Vehicles table
CREATE TABLE vehicles (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    cost_in_credits VARCHAR(100),
    length FLOAT,
    max_atmospheric_speed INT,
    crew INT,
    passengers INT,
    cargo_capacity BIGINT,
    consumables VARCHAR(100),
    vehicle_class VARCHAR(100),
    url VARCHAR(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    edited TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating Starships table
CREATE TABLE starships (
    starship_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    cost_in_credits VARCHAR(100),
    length FLOAT,
    max_atmospheric_speed INT,
    crew INT,
    passengers INT,
    cargo_capacity BIGINT,
    consumables VARCHAR(100),
    hyperdrive_rating FLOAT,
    MGLT INT,
    starship_class VARCHAR(100),
    url VARCHAR(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    edited TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Association tables with proper foreign key constraints
CREATE TABLE film_person (
    film_id INT,
    person_id INT,
    PRIMARY KEY (film_id, person_id),
    FOREIGN KEY (film_id) REFERENCES films(film_id) ON DELETE CASCADE,
    FOREIGN KEY (person_id) REFERENCES people(person_id) ON DELETE CASCADE
);

CREATE TABLE film_planet (
    film_id INT,
    planet_id INT,
    PRIMARY KEY (film_id, planet_id),
    FOREIGN KEY (film_id) REFERENCES films(film_id) ON DELETE CASCADE,
    FOREIGN KEY (planet_id) REFERENCES planets(planet_id) ON DELETE CASCADE
);

CREATE TABLE film_species (
    film_id INT,
    species_id INT,
    PRIMARY KEY (film_id, species_id),
    FOREIGN KEY (film_id) REFERENCES films(film_id) ON DELETE CASCADE,
    FOREIGN KEY (species_id) REFERENCES species(species_id) ON DELETE CASCADE
);

CREATE TABLE film_vehicle (
    film_id INT,
    vehicle_id INT,
    PRIMARY KEY (film_id, vehicle_id),
    FOREIGN KEY (film_id) REFERENCES films(film_id) ON DELETE CASCADE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id) ON DELETE CASCADE
);

CREATE TABLE film_starship (
    film_id INT,
    starship_id INT,
    PRIMARY KEY (film_id, starship_id),
    FOREIGN KEY (film_id) REFERENCES films(film_id) ON DELETE CASCADE,
    FOREIGN KEY (starship_id) REFERENCES starships(starship_id) ON DELETE CASCADE
);

-- Committing the transactions
COMMIT;
SET autocommit = 1;

