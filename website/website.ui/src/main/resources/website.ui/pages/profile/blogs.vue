<template>
  <div id="app" class="flex flex-col w-full">
    <div>
      <div class="flex mb-4 h-10 w-full">
        <div class="flex w-1/3">
          <icon-component />
        </div>
        <div class="flex w-full">
          <nav-component />
        </div>
      </div>
    </div>
    <div class="flex w-full component">
      <div
        v-if="blogs === undefined"
        class="flex justify-center items-center w-full h-52 animate-spin"
      >
        <font-awesome-icon
          class="text-6xl hover:text-blue-300"
          :icon="['fa', 'spinner']"
        />
      </div>
      <div v-else-if="blogs !== error" class="w-full">
        <div class="flex flex-col md:flex-row">
          <div
            class="flex flex-col items-center justify-center h-auto md:h-60 w-full md:w-2/5"
          >
            <div class="font-bold m-6">Enjoy reading one of our blogs.</div>
            <button v-on:click="showForm">Subscribe to our blogs</button>
            <div
              class="flex flex-col md:flex-row"
              v-bind:class="{ hidden: hideForm }"
            >
              
              <div class="flex flex-col justify-center p-1">
                <label for="firstname">First Name</label>
                <input
                  type="text"
                  id="firstname"
                  name="firstname"
                  placeholder="Your first name"
                  v-model="firstname"
                />
              </div>

              <div class="flex flex-col justify-center p-1">
                <label for="lastname">Last Name</label>
                <input
                  type="text"
                  id="lastname"
                  name="lastname"
                  placeholder="Your last name"
                  v-model="lastname"
                />
              </div>

              <div class="flex flex-col justify-center p-1">
                <label id="emailLabel" for="email" :class="[emailLabelError ? 'text-red-600' : '']">Email Address *</label>
                <input
                  type="text"
                  id="email"
                  name="email"
                  placeholder="pat@gmail.com"
                  size="20"
                  v-model="email"
                />
              </div>

              <div class="flex justify-center p-1">
                <button v-on:click="subscribe"><b>Submit</b></button>
              </div>
            </div>
            <div v-bind:class="{ hidden: !hideForm }">
              <p>
                <b>{{ formResult }}</b>
              </p>
            </div>
          </div>
          <div class="flex md:w-3/5 md:pt-10 content-center justify-center">
            <table class="w-full">
              <thead class="w-full bg-blue-100">
                <tr>
                  <th class="pt-4 pb-10">Blog Title</th>
                </tr>
              </thead>
              <tbody class="w-full">
                <NuxtLink
                  class="flex content-center items-center justify-center z-0 hover:shadow-md"
                  v-for="blog in blogs"
                  :key="blog.blogId"
                  :to="{ path: '/profile/blog', query: { id: blog.blogId } }"
                >
                  <tr>
                    <th class="pt-10 pb-10">{{ blog.blogTitle }}</th>
                  </tr>
                </NuxtLink>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div
        v-else
        class="flex flex-col justify-center items-center align-middle w-full"
      >
        <div>
          <font-awesome-icon
            class="fa-10x hover:text-blue-300"
            :icon="['fa', 'exclamation-triangle']"
          />
        </div>
        <div class="pt-5 italic">{{ error }} loading the blogs</div>
      </div>
    </div>
    <div class="flex h-40 pt-10 w-full">
      <footer-component :footer="footer" />
    </div>
  </div>
</template>
<script>
import Header from "@/components/Header.vue";
import Icon from "@/components/Icon.vue";
import Footer from "@/components/Footer.vue";
export default {
  name: "blogs-view",
  components: {
    "icon-component": Icon,
    "nav-component": Header,
    "footer-component": Footer,
  },
  data() {
    return {
      firstname: undefined,
      lastname: undefined,
      email: undefined,
      hideForm: true,
      formResult: undefined,
      emailLabelError: false,
      error: "An error occured",
      blogs: undefined,
      footer: {
        github: "https://github.com/pat-lego",
        twitter: "https://twitter.com/_patlego",
        linkedin: "https://www.linkedin.com/in/patrique-legault/",
        stackoverflow:
          "https://stackoverflow.com/users/8828583/patrique-legault",
      },
    };
  },
  head() {
    return {
      title: "Blogs",
      meta: [
        {
          hid: "description",
          name: "description",
          content: "Blogs",
        },
        {
          hid: "og:title",
          name: "og:title",
          content: "Patrique Legault Blogging Platform",
        },
        {
          hid: "og:description",
          name: "og:description",
          content: "Where all of my blogs are listed.",
        },
        {
          hid: "og:url",
          name: "og:url",
          content: "https://www.pat-lego.com/patlego/profile/blogs",
        },
        {
          hide: "twitter:title",
          name: "twitter:title",
          content: "Patrique Legault Blogging Platform",
        },
        {
          hide: "twitter:description",
          name: "twitter:description",
          content: "Where all of my blogs are listed.",
        },
        {
          hid: "keywords",
          name: "keywords",
          content:
            "Web Development, Blogs, Blogging, Vue.js, Java, OSGi, Apache Karaf, Technical Architect, Amazon Web Services",
        },
      ],
    };
  },
  /**
   * This fetch invocation is performed on the client, as you can see below the fetchOnServer parameter is set to false.
   * In comparison fetch and asyncData are both used to retrieve data on the server and then merge it into the page template.
   * This is not something that works well when generating static HTML since there is no server rendering the HTML page.
   *
   * If external data is to be fixed for a long period of time then using asyncData
   * is a wise investment.
   *
   * Refer to these options when using asyncData as it needs to know the external service endpoint in order to retrieve the data
   * at build time https://http.nuxtjs.org/options/
   */
  async fetch() {
    if (process.env.NODE_ENV === "development") {
      try {
        this.blogs = await fetch(
          "http://localhost:8181/cxf/patlegovm/1.0/site/blogs"
        ).then((res) => res.json());
      } catch (e) {
        this.blogs = this.error;
      }
    } else {
      try {
        this.blogs = await fetch("/cxf/patlegovm/1.0/site/blogs").then((res) =>
          res.json()
        );
      } catch (e) {
        this.blogs = this.error;
      }
    }
  },
  fetchOnServer: false,
  methods: {
    showForm: function (event) {
      this.hideForm = false;
    },
    subscribe: async function (event) {
      if (this.email === undefined || this.email.trim() === "") {
        this.emailLabelError = true
        return;
      }

      if (process.env.NODE_ENV === "development") {
        try {
          const url = await this.$axios.post(
            "http://localhost:8181/cxf/patlegovm/1.0/site/subscribe/create",
            {
              firstName: this.firstname,
              lastName: this.lastname,
              email: this.email,
            }
          );
          this.formResult = "You have successfully registered. Thank you";
        } catch (error) {
          this.formResult = "You have already subscribed";
          console.error("Failed to subscribe user");
        }
      } else {
        try {
          const url = await this.$axios.post(
            "/cxf/patlegovm/1.0/site/subscribe/create",
            {
              firstName: this.firstname,
              lastName: this.lastname,
              email: this.email,
            }
          );
          this.formResult = "You have successfully registered. Thank you";
        } catch (error) {
          this.formResult = "You have already subscribed";
          console.error("Failed to subscribe user");
        }
      }
      this.firstname = undefined;
      this.lastname = undefined;
      this.email = undefined;
      this.hideForm = true;
      this.emailLabelError = false;
    },
  },
};
</script>