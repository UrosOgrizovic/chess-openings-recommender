const ENVIRONMENTS = {
    localhost: 'dev'
  };

const BACKEND_HOSTNAMES = {
    dev: 'http://localhost:8443',
    production: ''
  };

const APP_HOSTNAMES = {
    dev: 'http://localhost:4200',
    production: ''
  };

const API_ROUTE = '/api';

const AGG = 'AGGRESSIVE';
const TAC = 'TACTICAL';
const POS = 'POSITIONAL';
const DEF = 'DEFENSIVE';
const MOVE_TYPES_PER_IMAGE = {Bxh7$Qf5$Ng5: [TAC, AGG, POS], e5$Bxf6$Bb5: [TAC, AGG, POS], exf4$d5$Bc5: [POS, TAC, AGG],
                              g5$Bxf6$Rxd5: [DEF, TAC, POS], Nf3$Qxd4$c3: [POS, DEF, AGG], 'Ng5$d3$O-O': [AGG, POS, TAC],
                              Nxe4$Nxd5$Bxf2: [AGG, DEF, TAC], Qa4$b4: [TAC, DEF], Qd2$Qe5$Qxc5: [DEF, TAC, AGG],
                              Qf3$Qh5$Bxf7: [POS, TAC, AGG], Qxc5$Ne4$Nh5: [DEF, TAC, POS], Qxg3$Qf7$Qd2: [AGG, TAC, POS],
                              Ra4$Rxa5$Nd2: [POS, AGG, DEF], Rxa7$Kd2$d4: [AGG, TAC, DEF]};

export {
    ENVIRONMENTS,
    BACKEND_HOSTNAMES,
    APP_HOSTNAMES,
    API_ROUTE,
    MOVE_TYPES_PER_IMAGE
  };

