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

const AGGRESSIVE_MOVES = ['Bc5', 'c3', 'Ng5'];
const TACTICAL_MOVES = ['d5', 'O-O', 'Qa4'];
const POSITIONAL_MOVES = ['exf4', 'Nf3', 'd3'];
const DEFENSIVE_MOVES = ['Qxd4', 'b4'];

export {
    ENVIRONMENTS,
    BACKEND_HOSTNAMES,
    APP_HOSTNAMES,
    API_ROUTE,
    AGGRESSIVE_MOVES,
    TACTICAL_MOVES,
    POSITIONAL_MOVES,
    DEFENSIVE_MOVES
  };

