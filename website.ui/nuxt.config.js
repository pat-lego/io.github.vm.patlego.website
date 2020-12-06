export default {
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
    ],
    link: [{ rel: "icon", type: "image/x-icon", href: "~/assets/favicon.ico" }],
  },
  target: "static",
  buildModules: ["@nuxtjs/tailwindcss", "@nuxtjs/fontawesome"],
  fontawesome: {
    icons: {
      solid: true,
      brands: true,
    },
  },
};
