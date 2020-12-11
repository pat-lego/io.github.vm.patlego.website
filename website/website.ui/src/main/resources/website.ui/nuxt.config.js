export default {
  router: {
    base: '/patlego/'
  },
  head: {
    title: "Patrique Legault",
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      {
        hid: "description",
        name: "description",
        content: "My personal website",
      },
      // Open Graph Tags
      {
        hid: "og:title",
        name: "og:title",
        content: "Patrique Legault"
      },
      {
        hid: "og:description",
        name: "og:description",
        content: "Development without limits"
      },
      {
        hid: "og:image",
        name: "og:image",
        content: "https://drive.google.com/file/d/1kDBpd180V1WkBaoaRPunXG4w2PeSiZQO/view?usp=sharing"
      },
      {
        hid: "og:url",
        name: "og:url",
        content: "https://www.pat-lego.com/patlego/profile"
      }
    ]
  },
  target: "static",
  buildModules: ["@nuxtjs/tailwindcss", "@nuxtjs/fontawesome"],
  fontawesome: {
    icons: {
      solid: true,
      brands: true,
    },
  },
  plugins: [{
    src: '~/plugins/hotjar.js',
    mode: 'client'
  }],
  css: [
    '~/assets/css/roboto.css',
    '~/assets/css/styles.css',
  ]
};
