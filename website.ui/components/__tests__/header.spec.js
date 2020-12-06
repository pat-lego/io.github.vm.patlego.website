import Header from '@/components/Header.vue'
import { shallowMount } from '@vue/test-utils'

describe('Header.vue', () => {
  it('header tabs', () => {
    const wrapper = shallowMount(Header, {
      stubs: ['router-link']
    })
    expect(wrapper.html().match(new RegExp('header-item', 'g') || []).length).toEqual(3)
  })
})
