const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/elevators',
    createProxyMiddleware({
      target: process.env.REACT_APP_PROXY_TARGET || 'http://0.0.0.0:9000',
      changeOrigin: true,
    })
  );
};