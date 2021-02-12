import Profile from '@/components/Profile.vue'
import { shallowMount } from '@vue/test-utils'

describe('Profile.vue', () => {
  it('test profile with just name', () => {
    const wrapper = shallowMount(Profile, {
      propsData: {
        profile: {
          name: 'Pat'
        }
      }
    })
    expect(wrapper.html()).toContain('Name')
    expect(wrapper.html()).not.toContain('Email')
    expect(wrapper.html()).not.toContain('Number')
    expect(wrapper.html()).not.toContain('Career')
    expect(wrapper.html()).not.toContain('Location')
    expect(wrapper.html()).not.toContain('Experience')
  })
})
