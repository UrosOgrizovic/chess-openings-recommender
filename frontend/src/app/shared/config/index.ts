import {
    ENVIRONMENTS,
    BACKEND_HOSTNAMES,
    API_ROUTE
} from '../constants';

const config = {
    getEnv() {
      return ENVIRONMENTS[window.location.hostname];
    },

    getHostName() {
      return BACKEND_HOSTNAMES[this.getEnv()];
    },

    getApiUrl() {
      return this.getHostName() + API_ROUTE;
    },

    isProductionEnv() {
      return this.getEnv() === 'production';
    },

  };

export { config };
